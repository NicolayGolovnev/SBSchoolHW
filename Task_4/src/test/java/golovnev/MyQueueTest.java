package golovnev;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MyQueueTest {
    /**
     * Тест, проверяющий работу метода isEmpty пустой очереди
     */
    @Test
    public void testIsEmptyWithoutElem(){
        MyQueue q = new MyQueue();
        var res = q.isEmpty();
        assertTrue(res);
    }

    /**
     * Тест, проверяющий работу метода isEmpty после добавления и удаления элементов очереди
     */
    @Test
    public void testIsEmptyWithElements(){
        MyQueue q = new MyQueue();
        q.enqueue(1);
        q.enqueue(1);
        q.enqueue(1);
        q.dequeue();
        q.dequeue();
        q.dequeue();
        var res = q.isEmpty();
        assertTrue(res);
    }

    /**
     * Тест, проверяющий работу метода top
     */
    @Test
    public void testTop(){
        MyQueue q = new MyQueue();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(2);
        q.enqueue(2);
        q.enqueue(1);
        var res = q.top();
        assertEquals(1, res);
    }

    /**
     * Тест, проверяющий ошибку на переполнение очереди (максимум всего доступно 128 элементов)
     */
    @Test
    public void testOverflawQueue(){
        MyQueue q = new MyQueue();
        var error = 0;
        for (int i = 0; i < 200; i++){
            error = q.enqueue(i);
            if (error == -1)
                break;
        }
        assertEquals(-1, error);
    }

    /**
     * Тест, проверяющий работу метода dequeue пустой очереди.
     */
    @Test
    public void testDequeFromEmptyQueue(){
        MyQueue q = new MyQueue();
        var error = q.dequeue();
        assertEquals(-1, error);
    }

    /**
     * Тест, проверяющий работу правильного добавления элементов в очередь
     */
    @Test
    public void testCheckData(){
        MyQueue q = new MyQueue();
        q.enqueue(4);
        q.enqueue(1);
        q.enqueue(5);
        q.enqueue(9);
        q.enqueue(9);
        assertArrayEquals(new Object[]{4, 1, 5, 9, 9}, q.getObjectArray());
    }
}
