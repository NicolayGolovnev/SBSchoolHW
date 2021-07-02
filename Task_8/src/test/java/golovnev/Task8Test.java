package golovnev;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task8Test {
    /**
     * Тест метода {@link Task8#getWordsByFrequency(String)}.
     * Слова "hello", "," встречаются один раз, остальные - от количества букв q в слове
     */
    @Test
    void getWordsByFrequency() {
        assertArrayEquals(new String[] {"qqqq", "qqq", "qq", "hello", ","}, Task8.getWordsByFrequency("hello , qqqq qqqq qqqq qq qqq qq qqq qqq qqqq"));
    }

    /**
     * Тест метода {@link Task8#getWordsByFrequency(String)}.
     * В качестве исходного текста передаются слова в верхнем и нижнем регистре
     */
    @Test
    void testMethodByUpperAndLowerRegister() {
        assertArrayEquals(new String[] {"qqqq", "qqq", "qq", "hello", ","}, Task8.getWordsByFrequency("HEllO , QQQQ QqqQ QQqq Qq QQQ qQ QqQ QQQ QQQq"));
    }

    /**
     * Тест исключения {@link NullPointerException} в методе {@link Task8#getWordsByFrequency(String)}.
     * Обрабатывается, когда исходный текст пуст
     */
    @Test
    void testNullPointerException() {
        assertThrows(NullPointerException.class, () -> Task8.getWordsByFrequency(""));
    }

}