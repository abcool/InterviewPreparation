import java.util.Map;
import java.util.concurrent.*;

public class RateLimiterManager {
    private final long capacity;
    private final long refillRate;
    private final ConcurrentHashMap<String, TokenBucket> clientBuckets = new ConcurrentHashMap<>();
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public RateLimiterManager(long capacity, long refillRate) {
        this.capacity = capacity;
        this.refillRate = refillRate;
        startRefillTask();
    }

    private void startRefillTask() {
        scheduler.scheduleAtFixedRate(() -> {
            for (Map.Entry<String, TokenBucket> entry : clientBuckets.entrySet()) {
                entry.getValue().refill();
            }
        }, 0, 1, TimeUnit.SECONDS);
    }

    public boolean allowRequest(String clientId) {
        TokenBucket bucket = clientBuckets.computeIfAbsent(clientId,
                id -> new TokenBucket(capacity, refillRate));
        return bucket.allowRequest();
    }

    public void shutdown() {
        scheduler.shutdown();
    }
}

