package golovnev;

import java.util.List;

/**
 * Класс, реализующий клиента банка
 */
public class Client extends Thread {
    /**
     * Банк, которым пользуется клиент
     */
    private final Bank bank;

    public Client(Bank bank) {
        this.bank = bank;
    }

    /**
     * Клиент переводит единожды случайную сумму с одного случайного счета на другой случайный счет
     * @see Bank#randomTwoAccounts(List)
     * @see Bank#randomAmount()
     */
    @Override
    public void run() {
        List<Account> twoAccounts = Bank.randomTwoAccounts(bank.getAccounts());
        bank.makeTransaction(twoAccounts.get(0), twoAccounts.get(1), Bank.randomAmount());
    }
}
