package golovnev.xiaomi;

import golovnev.gadgets.Tablet;

/**
 * Класс, реализующий сущность планшета от компании Xiaomi
 */
public class XiaomiTablet implements Tablet {
    /**
     * Конструктор, который выводит сообщение о создании экземпляра
     */
    public XiaomiTablet(){
        System.out.println("Constructor of Xiaomi tablet - tablet is created");
    }
}
