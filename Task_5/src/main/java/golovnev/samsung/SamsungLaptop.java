package golovnev.samsung;

import golovnev.gadgets.Laptop;

/**
 * Класс, реализующий сущность ноутбука от компании Samsung
 */
public class SamsungLaptop implements Laptop {
    /**
     * Конструктор, который выводит сообщение о создании экземпляра
     */
    public SamsungLaptop(){
        System.out.println("Constructor of Samsung Laptop - laptop is created");
    }
}
