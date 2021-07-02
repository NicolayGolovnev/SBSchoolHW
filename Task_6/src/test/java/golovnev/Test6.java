package golovnev;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

public class Test6 {
    private static Collection<UserSber> collA;
    private static Collection<UserSber> collB;

    /**
     * Проинициализируем коллекции для тестирования
     */
    @BeforeAll
    public static void setUp() {
        collA = new ArrayList<>();
        collB = new ArrayList<>();

        for (int i = 0; i < 100_000; i++) {
            collA.add(new UserSber("AAA" + i, "aaa" + i));
            if (i % 100 == 0)
                collB.add(new UserSber("AAA" + i, "aaa" + i));
            else
                collB.add(new UserSber("AAA" + -i, "aaa" + i));
        }
    }

    /**
     * Тест первого метода: проверка на корректность результата, времени работы
     */
    @Test
    public void testMethodFirst() {
        assertTimeoutPreemptively(Duration.ofMillis(200),() ->
                assertEquals(1000, MyUtils.findDuplicatesFirst(collA, collB).size()));
    }

    /**
     * Тест второго метода: проверка на корректность результата, времени работы
     */
    @Test
    public void testMethodSecond() {
        assertTimeoutPreemptively(Duration.ofMillis(200),() ->
                assertEquals(1000, MyUtils.findDuplicatesSecond(collA, collB).size()));
    }

    /**
     * Тест третьего метода: проверка на корректность результата, времени работы
     */
    @Test
    public void testMethodThird() {
        assertTimeoutPreemptively(Duration.ofMillis(200),() ->
                assertEquals(1000, MyUtils.findDuplicatesThird(collA, collB).size()));
    }
}
