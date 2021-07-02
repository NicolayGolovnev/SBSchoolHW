package golovnev;

import org.junit.jupiter.api.*;

import java.util.NoSuchElementException;
import java.util.Random;

class ArrayIteratorTest {

    /**
     * {@code array} - двумерный массив {@code Integer} для тестирования;
     * {@code iterator} - итератор для двумерного массива;
     * {@code row} - количество строк в массиве;
     * {@code column} - количество столбцов в массиве;
     */
    private static Integer[][] array;
    private static ArrayIterator<Integer> iterator;
    private static int row, column;

    /**
     * Проинициализируем двумерный массив для тестирования - элементы массива поочередно
     * заполняются значениями от 0 до {@code row * column}
     */
    @BeforeAll
    static void init() {
        Random rand = new Random();
        row = rand.nextInt(500) + 1;
        column = rand.nextInt(500) + 1;
        array = new Integer[row][column];
        for (int i = 0; i < row; i++)
            for (int j = 0; j < column; j++)
                array[i][j] = i * column + j;
    }

    /**
     * Проинициализируем итератор перед каждым выполнением теста
     */
    @BeforeEach
    void setUp() {
        iterator = new ArrayIterator<>(array);
    }

    /**
     * Тест метода {@link ArrayIterator#hasNext()}.
     * Выдаст {@code false} при прохождении всего массива
     */
    @Test
    void testHasNext() {
        int size = 0;
        while (iterator.hasNext()) {
            iterator.next();
            size++;
        }
        Assertions.assertEquals(row * column, size);
    }

    /**
     * Тест метода {@link ArrayIterator#next()}.
     * Поочередно проверяем каждый элемент массива
     */
    @Test
    void testNext() {
        int size = 0;
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            Assertions.assertEquals(size, next);
            size++;
        }
    }

    /**
     * Тест исключения {@link java.util.NoSuchElementException} в методе {@link ArrayIterator#next()}.
     * Обрабатывается, когда в массиве закончились элементы
     */
    @Test
    void testNoSuchElementException() {
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            int size = 0;
            while(iterator.hasNext())
                iterator.next();
            iterator.next();
        });
    }
}