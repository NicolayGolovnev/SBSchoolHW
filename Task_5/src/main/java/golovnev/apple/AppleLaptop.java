package golovnev.apple;

import golovnev.gadgets.Laptop;

/**
 * Класс, реализующий сущность ноутбука от компании Apple
 */
public class AppleLaptop implements Laptop {
    /**
     * Конструктор, который выводит сообщение о создании экземпляра
     */
    public AppleLaptop(){
        System.out.println("Constructor of Apple Laptop - laptop is created");
    }
}
