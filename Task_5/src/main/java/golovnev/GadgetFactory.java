package golovnev;

import golovnev.gadgets.Laptop;
import golovnev.gadgets.Phone;
import golovnev.gadgets.Tablet;

/**
 * Интерфейс, реализующий абстрактную фабрику производства гаджетов.
 * Возможно создание: телефона, планшета, ноутбука
 */
public interface GadgetFactory {
    /**
     * Абстрактный метод для создания телефона
     * @return экземпляр телефона выбранной компании
     */
    Phone createPhone();

    /**
     * Абстрактный метод для создания планшета
     * @return экземпляр планшета выбранной компании
     */
    Tablet createTablet();

    /**
     * Абстракстный метод для создания ноутбука
     * @return экземпляр ноутбука выбранной компании
     */
    Laptop createLaptop();
}
