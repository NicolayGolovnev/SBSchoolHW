package golovnev;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Класс ArrayIterator, который работает с двумерными массивами. Реализует интерфейс {@link Iterator}
 * @param <T> тип данных
 */
public class ArrayIterator<T> implements Iterator<T> {
    /**
     * {@code array} - поле для двумерного массива;
     * {@code size} - поле для хранения количества элементов массива;
     * {@code currentIndex} - поле для хранения текущего индекса массива
     */
    private final T[][] array;
    private final int size;
    private int currentIndex;

    /**
     * Конструктор с одним параметром
     * @param array переданный массив
     */
    public ArrayIterator(T[][] array) {
        this.array = array;
        currentIndex = 0;
        this.size = array.length * array[0].length;
    }

    /**
     * Метод, который проверяет, остались ли элементы в массиве.
     * @return {@code true} если есть элементы, {@code false} - не осталось
     */
    @Override
    public boolean hasNext() {
        return currentIndex != size;
    }

    /**
     * Метод, который возвращает следующий элемент массива
     * @return следующий элемент массива
     * @throws NoSuchElementException если не осталось больше элементов
     */
    @Override
    public T next() throws NoSuchElementException {
        if (!hasNext()) throw new NoSuchElementException();

        int row = currentIndex / array[0].length;
        int column = currentIndex % array[0].length;
        currentIndex++;
        return array[row][column];
    }
}
