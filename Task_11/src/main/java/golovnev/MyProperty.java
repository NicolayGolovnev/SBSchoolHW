package golovnev;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Класс, который реализует работу с файлом конфигурации .properties
 */
public class MyProperty {
    /**
     * Объект {@code Properties}, необходимый для работы с файлом конфигурации
     */
    private static final Properties prop = new Properties();

    /**
     * Строки-константы для безошибочного получения нужно ключа для поиска значения
     */
    public final static String AMOUNT_CLIENTS = "amount_clients";
    public final static String AMOUNT_ACCOUNTS = "amount_accounts";
    public final static String MAX_AMOUNT_TRANSACTION = "max_amount_transaction";
    public final static String FAIL = "fail";

    /**
     * Статический метод, с помощью которого можно подключить конфигурационный файл
     * @param nameCfg путь до файла
     * @throws RuntimeException если не удалось найти и загрузить файл конфигурации
     */
    public static void init(String nameCfg){
        try {
            prop.load(new FileInputStream(nameCfg));
        } catch (IOException e) {
            throw new RuntimeException("Couldn't find and load the file of configuration!");
        }
    }

    /**
     * Метод, с помощью которого можно получить значение файла .properties по ключу
     * @param key ключ-строка
     * @return значение поля по ключу
     * @throws RuntimeException если заданного поля по ключу не существует
     * @see #foundValueProperty(String)
     */
    public static int getValueProperty(String key) {
        if (key.equals("fail") && !foundValueProperty(key))
            return 0;

        if (foundValueProperty(key))
            return Integer.parseInt(prop.getProperty(key));
        else
            throw new RuntimeException(String.format("Can't find the parameter %s in file .properties", key));
    }

    /**
     * Метод, который сообщает о наличии значения в заданном файле .properties по ключу {@code key}
     * @param key ключ-строка
     * @return {@code true} если поле найдено в файле, иначе {@code false}
     */
    private static boolean foundValueProperty(String key) {
        return prop.getProperty(key) != null;
    }
}
