package golovnev;

import golovnev.gadgets.Laptop;
import golovnev.gadgets.Phone;
import golovnev.gadgets.Tablet;
import golovnev.samsung.SamsungLaptop;
import golovnev.samsung.SamsungPhone;
import golovnev.samsung.SamsungTablet;

/**
 * Класс, являющийся реализацией фабрики компании Samsung. На ней могут сделать телефон, планшет, ноутбук.
 */
public class SamsungFactory implements GadgetFactory{
    /**
     * Метод, создающий телефон компании Samsung
     *
     * @return экземпляр телефона компании Samsung
     */
    @Override
    public Phone createPhone() {
        return new SamsungPhone();
    }

    /**
     * Метод, создающий планшет компании Samsung
     *
     * @return экземпляр планшета компании Samsung
     */
    @Override
    public Tablet createTablet() {
        return new SamsungTablet();
    }

    /**
     * Метод, создающий ноутбук компании Samsung
     *
     * @return экземпляр ноутбука компании Samsung
     */
    @Override
    public Laptop createLaptop() {
        return new SamsungLaptop();
    }
}
