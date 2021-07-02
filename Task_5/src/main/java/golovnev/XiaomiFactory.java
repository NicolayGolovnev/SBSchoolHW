package golovnev;

import golovnev.gadgets.Laptop;
import golovnev.gadgets.Phone;
import golovnev.gadgets.Tablet;
import golovnev.xiaomi.XiaomiLaptop;
import golovnev.xiaomi.XiaomiPhone;
import golovnev.xiaomi.XiaomiTablet;

/**
 * Класс, являющийся реализацией фабрики компании Xiaomi. На ней могут сделать телефон, планшет, ноутбук.
 */
public class XiaomiFactory implements GadgetFactory{
    /**
     * Метод, создающий телефон компании Xiaomi
     *
     * @return экземпляр телефона компании Xiaomi
     */
    @Override
    public Phone createPhone() {
        return new XiaomiPhone();
    }

    /**
     * Метод, создающий планшет компании Xiaomi
     *
     * @return экземпляр планшета компании Xiaomi
     */
    @Override
    public Tablet createTablet() {
        return new XiaomiTablet();
    }

    /**
     * Метод, создающий ноутбук компании Xiaomi
     *
     * @return экземпляр ноутбука компании Xiaomi
     */
    @Override
    public Laptop createLaptop() {
        return new XiaomiLaptop();
    }
}
