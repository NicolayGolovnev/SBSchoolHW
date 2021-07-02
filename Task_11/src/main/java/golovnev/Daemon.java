package golovnev;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 * Наблюдатель, который проверяет, чтобы сумма остатков на счетах банка была равна первоначальному значению
 */
public class Daemon extends Thread {
    /**
     * Банк, который проверяет наблюдатель
     */
    private final Bank bank;

    public Daemon(Bank bank) {
        this.bank = bank;
    }

    /**
     * Сверяет текущий остаток со всех счетов банка с первоначальным остатком. Как только мы заметили несовпадение,
     * сообщаем банку об ошибке, заканчиваем проверки.
     * @throws RuntimeException как только нашли несовпадения по остаткам
     */
    @Override
    public void run() {
        BigDecimal value1 = BigDecimal.valueOf(MyProperty.getValueProperty(MyProperty.MAX_AMOUNT_TRANSACTION));
        BigDecimal value2 = BigDecimal.valueOf(MyProperty.getValueProperty(MyProperty.AMOUNT_ACCOUNTS));
        BigDecimal bankAmount =  value1.multiply(value2);

        while (true) {
            bank.getAccounts().forEach(Account::lock);
            BigDecimal calculateAmount = calculate(bank.getAccounts());
            bank.getAccounts().forEach(Account::unlock);
            if (!bankAmount.equals(calculateAmount))
                throw new RuntimeException("There was a leak in transfers between accounts!");

            System.err.println("Daemon is alive? " + this.isAlive());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Метод для подсчета общей суммы банка с блокировкой ячеек на время считывания
     * @param accounts список всех счетов проверяемого банка
     * @return общая сумма банка
     */
    private BigDecimal calculate(List<Account> accounts) {
        BigDecimal value = new BigDecimal(BigInteger.ZERO);
        for (var account : accounts){
            account.lock();
            value = value.add(account.getBalance());
            account.unlock();
        }
        return value;
    }

    /**
     * Статический метод, который позволяет создать демона-наблюдателя за транзакциями клиентов
     * @param bank проверяемый банк
     * @return созданный объект-наблюдатель
     */
    public static Daemon startDaemon(Bank bank) {
        Daemon daemon = new Daemon(bank);
        daemon.setDaemon(true);
        daemon.start();
        return daemon;
    }
}
