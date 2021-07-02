package golovnev.samsung;

import golovnev.gadgets.Phone;

/**
 * Класс, реализующий сущность телефона от компании Samsung
 */
public class SamsungPhone implements Phone {
    /**
     * Конструктор, который выводит сообщение о создании экземпляра
     */
    public SamsungPhone(){
        System.out.println("Constructor of Samsung Phone - phone is created");
    }
}
