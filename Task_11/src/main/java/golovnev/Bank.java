package golovnev;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Класс, реализующий банк. Содержит доступные счета и выполняет операции над ними.
 */
public class Bank {
    /**
     * Поле, в котором хранятся все доступные счета банка
     */
    private final List<Account> accounts;

    public Bank(List<Account> accounts) {
        this.accounts = accounts;
    }

    /**
     * Геттер для списка счетов
     * @return список всех счетов банка
     */
    public List<Account> getAccounts() {
        return accounts;
    }

    /**
     * Метод транзакции с одного счета на другой, если есть необходимое количество денег на счете-переводчике
     * @param from счет, который переводит определенную сумму денег
     * @param to счет, который получает определенную сумму денег
     * @param value сумма перевода
     */
    public void makeTransaction(Account from, Account to, BigDecimal value) {
        try {
            from.lock();
            to.lock();
            if (from.getBalance().compareTo(value) < 0)
                return;

            from.setBalance(from.getBalance().subtract(value));
            System.err.println(Thread.currentThread().getName() + ": Transfered from " + from.toString() + " " + value.toString() + " value");

            to.setBalance(to.getBalance().add(value));
            System.err.println(Thread.currentThread().getName() + ": Transfered to " + to.toString() + " " + value.toString() + " value");
        } finally {
            from.unlock();
            to.unlock();
        }
    }

    /**
     * Статический метод для получения двух случайных счетов из общего пула счетов банка
     * @param accounts список всех счетов банка
     * @return список из 2 случайных счетов
     */
    public static List<Account> randomTwoAccounts(List<Account> accounts) {
        ThreadLocalRandom rand = ThreadLocalRandom.current();
        return IntStream.range(0, 2)
                .map(x -> rand.nextInt(accounts.size()))
                .mapToObj(accounts::get)
                .collect(Collectors.toList());
    }

    /**
     * Статический метод для получения случайного значения суммы транзакции между счетами
     * @return случайное значение от 0 до {@link MyProperty#MAX_AMOUNT_TRANSACTION}
     */
    public static BigDecimal randomAmount() {
        ThreadLocalRandom rand = ThreadLocalRandom.current();
        int value = MyProperty.getValueProperty(MyProperty.MAX_AMOUNT_TRANSACTION);
        return BigDecimal.valueOf(rand.nextInt(value));
    }
}
