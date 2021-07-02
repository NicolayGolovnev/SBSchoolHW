package golovnev.xiaomi;

import golovnev.gadgets.Phone;

/**
 * Класс, реализующий сущность телефона от компании Xiaomi
 */
public class XiaomiPhone implements Phone {
    /**
     * Конструктор, который выводит сообщение о создании экземпляра
     */
    public XiaomiPhone(){
        System.out.println("Constructor of Xiaomi Phone - phone is created");
    }
}
