package golovnev.apple;

import golovnev.gadgets.Tablet;

/**
 * Класс, реализующий сущность планшета от компании Apple
 */
public class AppleTablet implements Tablet {
    /**
     * Конструктор, который выводит сообщение о создании экземпляра
     */
    public AppleTablet(){
        System.out.println("Constructor of Apple Tablet - tablet is created");
    }
}
