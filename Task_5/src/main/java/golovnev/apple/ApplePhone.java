package golovnev.apple;

import golovnev.gadgets.Phone;

/**
 * Класс, реализующий сущность телефона от компании Apple
 */
public class ApplePhone implements Phone {
    /**
     * Конструктор, который выводит сообщение о создании экземпляра
     */
    public ApplePhone(){
        System.out.println("Constructor of Apple Phone - phone is created");
    }
}
