public class TokenBucket {
    private final long capacity;
    private final long refillRate; // tokens per second
    private double tokens;

    public TokenBucket(long capacity, long refillRate) {
        this.capacity = capacity;
        this.refillRate = refillRate;
        this.tokens = capacity;
    }

    public synchronized boolean allowRequest() {
        if (tokens >= 1) {
            tokens -= 1;
            return true;
        }
        return false;
    }

    public synchronized void refill() {
        tokens = Math.min(capacity, tokens + refillRate);
    }
}

