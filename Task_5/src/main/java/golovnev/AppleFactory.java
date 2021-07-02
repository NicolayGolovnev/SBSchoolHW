package golovnev;

import golovnev.apple.AppleLaptop;
import golovnev.apple.ApplePhone;
import golovnev.apple.AppleTablet;
import golovnev.gadgets.Laptop;
import golovnev.gadgets.Phone;
import golovnev.gadgets.Tablet;

/**
 * Класс, являющийся реализацией фабрики компании Apple. На ней могут сделать телефон, планшет, ноутбук.
 */
public class AppleFactory implements GadgetFactory{
    /**
     * Метод, создающий телефон компании Apple
     *
     * @return экземпляр телефона комании Apple
     */
    @Override
    public Phone createPhone() {
        return new ApplePhone();
    }

    /**
     * Метод, создающий планшет компании Apple
     *
     * @return экземпляр планшета компании Apple
     */
    @Override
    public Tablet createTablet() {
        return new AppleTablet();
    }

    /**
     * Метод, создающий ноутбук компании Apple
     *
     * @return экземпляр ноутбука компании Apple
     */
    @Override
    public Laptop createLaptop() {
        return new AppleLaptop();
    }
}
