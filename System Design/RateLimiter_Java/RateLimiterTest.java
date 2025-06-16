public class RateLimiterTest {
    public static void main(String[] args) throws InterruptedException {
        RateLimiterManager limiter = new RateLimiterManager(5, 2); // 5 tokens max, refill 2/sec

        String clientId = "client-123";

        for (int i = 0; i < 15; i++) {
            boolean allowed = limiter.allowRequest(clientId);
            System.out.println("Request " + i + ": " + (allowed ? "Allowed" : "Blocked"));
            Thread.sleep(300); // 300ms between requests
        }

        limiter.shutdown();
    }
}

