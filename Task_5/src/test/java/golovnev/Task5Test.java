package golovnev;

import golovnev.apple.AppleLaptop;
import golovnev.apple.ApplePhone;
import golovnev.apple.AppleTablet;
import golovnev.samsung.SamsungLaptop;
import golovnev.samsung.SamsungPhone;
import golovnev.samsung.SamsungTablet;
import golovnev.xiaomi.XiaomiLaptop;
import golovnev.xiaomi.XiaomiPhone;
import golovnev.xiaomi.XiaomiTablet;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Класс с тестами для провекри абстрактной фабрики
 */
public class Task5Test {
    /**
     * Проверка экземпляров устройств компании Apple
     */
    @Test
    public void AppleGadgetsTest(){
        GadgetFactory appleFactory = new AppleFactory();
        assertEquals(AppleFactory.class, appleFactory.getClass());
        assertEquals(ApplePhone.class, appleFactory.createPhone().getClass());
        assertEquals(AppleTablet.class, appleFactory.createTablet().getClass());
        assertEquals(AppleLaptop.class, appleFactory.createLaptop().getClass());
    }

    /**
     * Проверка экземпляров устройств компании Samsung
     */
    @Test
    public void SamsungGadgetsTest(){
        GadgetFactory samsungFactory = new SamsungFactory();
        assertEquals(SamsungFactory.class, samsungFactory.getClass());
        assertEquals(SamsungPhone.class, samsungFactory.createPhone().getClass());
        assertEquals(SamsungTablet.class, samsungFactory.createTablet().getClass());
        assertEquals(SamsungLaptop.class, samsungFactory.createLaptop().getClass());
    }

    /**
     * Проверка экземпляров устройств компании Xiaomi
     */
    @Test
    public void XiaomiGadgetsTest(){
        GadgetFactory xiaomiFactory = new XiaomiFactory();
        assertEquals(XiaomiFactory.class, xiaomiFactory.getClass());
        assertEquals(XiaomiPhone.class, xiaomiFactory.createPhone().getClass());
        assertEquals(XiaomiTablet.class, xiaomiFactory.createTablet().getClass());
        assertEquals(XiaomiLaptop.class, xiaomiFactory.createLaptop().getClass());
    }
}
