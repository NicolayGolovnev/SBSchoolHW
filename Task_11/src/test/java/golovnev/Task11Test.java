package golovnev;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Тестирующий класс для рассмотрения 2 положительных сценариев и 1 негативного сценария
 */
class Task11Test {
    /**
     * Поля для хранения значений .properties файла
     */
    private int amountAccounts;
    private int amountClients;
    private int maxAmountTransaction;

    @Test
    @DisplayName("N clients and M accounts")
    public void testPositive() {
        initializationCfg("src/test/resources/golovnev/cfg1.properties");

        List<Account> accounts = new ArrayList<>();
        for (int i = 0; i < amountAccounts; i++)
            accounts.add(new Account(BigDecimal.valueOf(maxAmountTransaction)));
        Bank bank = new Bank(accounts);
        Daemon daemon = Daemon.startDaemon(bank);

        for (int i = 1; i < amountClients; i++)
            new Client(bank).start();
        assertTrue(daemon.isAlive());
    }

    @Test
    @DisplayName("Wrong sum on the start Daemon")
    void testNegativeByWrongSum() {
        initializationCfg("src/test/resources/golovnev/cfg2.properties");

        List<Account> accounts = new ArrayList<>();
        for (int i = 0; i < amountAccounts; i++)
            accounts.add(new Account(BigDecimal.valueOf(maxAmountTransaction)));
        if (MyProperty.getValueProperty(MyProperty.FAIL) == 1)
            accounts.get(0).setBalance(accounts.get(0).getBalance().add(BigDecimal.valueOf(10000)));

        Bank bank = new Bank(accounts);
        Daemon daemon = Daemon.startDaemon(bank);

        for (int i = 1; i < amountClients; i++)
            new Client(bank).start();
        assertFalse(daemon.isAlive());
    }

    @Test
    @DisplayName("N clients and 2 accounts")
    void testPositiveByTwoAccounts() {
        initializationCfg("src/test/resources/golovnev/cfg3.properties");

        List<Account> accounts = new ArrayList<>();
        for (int i = 0; i < amountAccounts; i++)
            accounts.add(new Account(BigDecimal.valueOf(maxAmountTransaction)));
        Bank bank = new Bank(accounts);
        Daemon daemon = Daemon.startDaemon(bank);

        for (int i = 1; i < amountClients; i++)
            new Client(bank).start();
        assertTrue(daemon.isAlive());
    }

    /**
     * Метод, с помощью которого загружаю и определяю поля класса из файла .properties
     * @param name путь до файла
     */
    private void initializationCfg(String name) {
        MyProperty.init(name);
        amountAccounts = MyProperty.getValueProperty(MyProperty.AMOUNT_ACCOUNTS);
        amountClients = MyProperty.getValueProperty(MyProperty.AMOUNT_CLIENTS);
        maxAmountTransaction = MyProperty.getValueProperty(MyProperty.MAX_AMOUNT_TRANSACTION);
    }
}