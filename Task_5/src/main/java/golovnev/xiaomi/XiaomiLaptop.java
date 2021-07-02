package golovnev.xiaomi;

import golovnev.gadgets.Laptop;

/**
 * Класс, реализующий сущность ноутбука от компании Xiaomi
 */
public class XiaomiLaptop implements Laptop {
    /**
     * Конструктор, который выводит сообщение о создании экземпляра
     */
    public XiaomiLaptop(){
        System.out.println("Constructor of Xiaomi Laptop - laptop is created");
    }
}
