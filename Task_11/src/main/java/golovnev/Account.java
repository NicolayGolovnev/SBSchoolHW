package golovnev;

import java.math.BigDecimal;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Класс счета в банке
 */
public class Account {
    /**
     * Текущее значение денежных средств на счете банка
     */
    private BigDecimal balance;
    /**
     * Блокировщик, необходимый для ограничения доступа к балансу денежных средств
     */
    private final ReentrantLock lock;

    public Account(BigDecimal balance) {
        this.balance = balance;
        this.lock = new ReentrantLock();
    }

    /**
     * Геттер для баланса счета
     * @return баланс текущего счета
     */
    public BigDecimal getBalance() {
        return balance;
    }

    /**
     * Сеттер для баланса счета
     * @param balance новый баланс счета
     */
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    /**
     * Метод для закрытия доступа к балансу счета
     */
    public void lock() {
        try {
            lock.lockInterruptibly();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод для открытия доступа к балансу счета
     */
    public void unlock() {
        lock.unlock();
    }

}
