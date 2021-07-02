package golovnev;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MyStackTest {
    /**
     * Тест пустого стека на ошибку возврата элемента из верхушки стека
     */
    @Test
    public void testPop(){
        MyStack st = new MyStack();
        Object error = st.pop();
        assertNull(error);
    }

    /**
     * Тест, проверяющий работу правильного добавления элементов в стек
     */
    @Test
    public void testCheckData(){
        MyStack st = new MyStack();
        st.push(1);
        st.push(2);
        st.push(3);
        assertArrayEquals(new Object[]{3, 2, 1}, st.getObjectArray());
    }

    /**
     * Тест, проверяющий ошибку на переполнение стека (максимум всего доступно 128 элементов)
     */
    @Test
    public void testOverflawStack(){
        MyStack st = new MyStack();
        int error = 0;
        for (int i = 0; i < 200; i++){
            error = st.push(i);
            if (error == -1)
                break;
        }
        assertEquals(-1, error);
    }

    /**
     * Проверку на правильное позиционирование указателя внутри класса
     */
    @Test
    public void testPointer(){
        MyStack st = new MyStack();
        for (int i = 0; i < 10; i++)
            st.push(i);
        st.pop();
        st.pop();
        assertEquals(8, st.top());
    }

    /**
     * Тест на проверку пустоты стека (в стек добавляются и удаляются элементы)
     */
    @Test
    public void testIsEmpty(){
        MyStack st = new MyStack();
        st.push(1);
        st.push(1);
        st.pop();
        st.pop();
        var result = st.isEmpty();
        assertTrue(result);
    }
}
