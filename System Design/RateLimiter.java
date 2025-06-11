/* Add dependencies
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-gateway</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-redis-reactive</artifactId>
</dependency>
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt</artifactId>
    <version>0.9.1</version>
</dependency>
*/


/* Add yml configs
spring:
  cloud:
    gateway:
      routes:
        - id: jwt-limited-route
          uri: http://localhost:8081
          predicates:
            - Path=/api/user/**
          filters:
            - name: RequestRateLimiter
              args:
                redis-rate-limiter.replenishRate: 3    # 3 requests/sec
                redis-rate-limiter.burstCapacity: 5
                key-resolver: "#{@jwtKeyResolver}"

  redis:
    host: localhost
    port: 6379

*/

// Add Config

@Configuration
public class RateLimiterConfig {

    private static final String BEARER_PREFIX = "Bearer ";

    @Bean
    public KeyResolver jwtKeyResolver() {
        return exchange -> {
            String authHeader = exchange.getRequest().getHeaders().getFirst(HttpHeaders.AUTHORIZATION);

            if (authHeader == null || !authHeader.startsWith(BEARER_PREFIX)) {
                return Mono.just("anonymous"); // fallback for unauthenticated
            }

            String token = authHeader.substring(BEARER_PREFIX.length());

            try {
                Claims claims = Jwts.parser()
                        .setSigningKey("my-secret-key".getBytes(StandardCharsets.UTF_8)) // Use same signing key as JWT issuer
                        .parseClaimsJws(token)
                        .getBody();

                String userId = claims.getSubject(); // or claims.get("userId")
                return Mono.just(userId);
            } catch (Exception e) {
                return Mono.just("invalid"); // fallback for invalid token
            }
        };
    }
}

// Add filter to get rate limit called

@Component
public class CustomRateLimiterFilter implements GlobalFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        if (exchange.getResponse().getStatusCode() == HttpStatus.TOO_MANY_REQUESTS) {
            exchange.getResponse().getHeaders().setContentType(MediaType.APPLICATION_JSON);
            byte[] bytes = "{\"error\": \"Rate limit exceeded. Try again later.\"}".getBytes(StandardCharsets.UTF_8);
            return exchange.getResponse().writeWith(Mono.just(exchange.getResponse()
                    .bufferFactory().wrap(bytes)));
        }
        return chain.filter(exchange);
    }
}

