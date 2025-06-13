package intewiew;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Write TTL cache
 */
public class Netflix {

    public static void main(String[] args) throws InterruptedException{
        TTLCache<String, String> cache = new TTLCache<>();
        cache.put("key", "value", 1L);
        System.out.println(cache.get("key"));

        Thread.sleep(100L);

        System.out.println(cache.get("key"));
    }

    static class TTLCache<K, V> {
        private final ConcurrentHashMap<K, V> cacheMap = new ConcurrentHashMap<>();
        private final ConcurrentHashMap<K, Long> expiryTimes = new ConcurrentHashMap<>();
        private final ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);

        public TTLCache() {
            executorService.scheduleAtFixedRate(this::cleanupExpiredEntries, 2, 50, TimeUnit.SECONDS);
        }

        public void put(K key, V value, long ttl) {
            if (key == null || value == null) {
                throw new NullPointerException("Key and value cannot be null");
            }
            if (ttl <= 0) {
                throw new IllegalArgumentException("TTL must be positive");
            }

            long expiryTime = System.currentTimeMillis() + ttl;
            cacheMap.put(key, value);
            expiryTimes.put(key, expiryTime);
        }

        public V get(K key) {
            if (key == null) return null;

            Long expiryTime = expiryTimes.get(key);
            if (expiryTime == null) {
                return null;
            }

            if (System.currentTimeMillis() > expiryTime) {
                remove(key);
                return null;
            }

            return cacheMap.get(key);
        }

        public void remove(K key) {
            cacheMap.remove(key);
            expiryTimes.remove(key);
        }

        private void cleanupExpiredEntries() {
            long currentTime = System.currentTimeMillis();
            for (Map.Entry<K, Long> entry : expiryTimes.entrySet()) {
                if (currentTime > entry.getValue()) {
                    remove(entry.getKey());
                }
            }
        }
    }
}
