package intewiew;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;


public class RateLimiter {
    private final int maxRequests;
    private final long timeWindow;

    private final ConcurrentHashMap<String, LinkedBlockingDeque<Long>> requests = new ConcurrentHashMap<>();

    public RateLimiter(int maxRequests, long timeWindowInMillis) {
        this.maxRequests = maxRequests;
        this.timeWindow = timeWindowInMillis;
    }

    public boolean allowRequest(String clientId) {
        long currentTime = System.currentTimeMillis();
        LinkedBlockingDeque<Long> clientRequests = requests.computeIfAbsent(
                clientId,
                k -> new LinkedBlockingDeque<>(maxRequests)
        );

        // Удаляем старые запросы
        while (!clientRequests.isEmpty() && currentTime - clientRequests.peekFirst() > timeWindow) {
            clientRequests.pollFirst();
        }

        if (clientRequests.size() < maxRequests) {
            clientRequests.addLast(currentTime);
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws InterruptedException {
        RateLimiter limiter = new RateLimiter(2, 1000); // 2 запроса в секунду

        System.out.println(limiter.allowRequest("client1")); // true
        System.out.println(limiter.allowRequest("client1")); // true
        System.out.println(limiter.allowRequest("client1")); // false

        TimeUnit.SECONDS.sleep(1);
        System.out.println(limiter.allowRequest("client1")); // true (окно сброшено)
    }
}
