package intewiew;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * сделай так что б этот код работал в много поточной среде
 * <p>
 * public class Bank {
 * private final Map<String, Integer> accounts = new HashMap<>();
 * <p>
 * public void addAccount(String name, int balance) {
 * accounts.put(name, balance);
 * }
 * <p>
 * public void transfer(String from, String to, int amount) {
 * int fromBalance = accounts.get(from);
 * int toBalance = accounts.get(to);
 * <p>
 * if (fromBalance >= amount) {
 * accounts.put(from, fromBalance - amount);
 * accounts.put(to, toBalance + amount);
 * }
 * }
 * <p>
 * public int getTotalBalance() {
 * return accounts.values().stream().mapToInt(Integer::intValue).sum();
 * }
 * }
 */
public class REPartner {

    public static void main(String[] args) {

    }

    // make thread safe
    class Bank {

        private final Map<String, Integer> accounts = new ConcurrentHashMap<>();
        private final Map<String, Lock> accountLocks = new ConcurrentHashMap<>();
        private final Lock totalBalanceLock = new ReentrantLock();

        public void addAccount(String name, int balance) {
            accounts.put(name, balance);
            accountLocks.put(name, new ReentrantLock());
        }

        public void transfer(String from, String to, int amount) {
            Lock firstLock = accountLocks.get(from);
            try {

                firstLock.lock();

                int fromBalance = accounts.get(from);
                int toBalance = accounts.get(to);

                if (fromBalance >= amount) {
                    accounts.put(from, fromBalance - amount);
                    accounts.put(to, toBalance + amount);
                } else {
                    throw new IllegalStateException("Insufficient funds");
                }
            } finally {
                firstLock.unlock();
            }
        }

        public int getTotalBalance() {
            totalBalanceLock.lock();
            try {
                // Блокируем все счета для получения согласованного баланса
                accountLocks.values().forEach(Lock::lock);
                try {
                    return accounts.values().stream().mapToInt(Integer::intValue).sum();
                } finally {
                    accountLocks.values().forEach(Lock::unlock);
                }
            } finally {
                totalBalanceLock.unlock();
            }
        }

        public int getBalance(String accountName) {
            return accounts.get(accountName);
        }
    }
}
