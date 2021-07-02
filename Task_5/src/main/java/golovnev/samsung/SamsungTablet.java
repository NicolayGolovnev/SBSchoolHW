package golovnev.samsung;

import golovnev.gadgets.Tablet;

/**
 * Класс, реализующий сущность планшета от компании Samsung
 */
public class SamsungTablet implements Tablet {
    /**
     * Конструктор, который выводит сообщение о создании экземпляра
     */
    public SamsungTablet(){
        System.out.println("Constructor of Samsung tablet - tablet is created");
    }
}
