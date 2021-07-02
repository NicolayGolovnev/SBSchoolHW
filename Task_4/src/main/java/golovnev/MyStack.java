package golovnev;

/**
 * Класс, который реализует стэк (принцип LIFO)
 */
public class MyStack {
    /**
     * Поле st - массив Object, который реализует наш стек. Ограничен 128 объектами, предназначен для хранения элементов
     * в стеке
     */
    private Object[] st;
    /**
     * Поле pointer - позиция стека, который указывает на пустое место для новой записи
     */
    private int pointer;

    /**
     * Конструктор класса
     */
    MyStack(){
        st = new Object[128];
        pointer = 0;
    }

    /**
     * Метод, реализующий добавления объекта в стек
     * @param number заносимый объект
     * @return 1 в случае успешного добавления, -1 в случае провала
     */
    public int push(Object number){
        if (pointer < st.length) {
            st[pointer++] = number;
            return 1;
        }
        else
            return -1;
    }

    /**
     * Метод, руализующий проверку на пустоту стека
     * @return true, если стек пуст, иначе false
     */
    public boolean isEmpty(){
        return (pointer == 0);
    }

    /**
     * Метод, реализующий возврат элемента верхушки стека
     * @return элемент, который находился в верху стека
     */
    public Object pop(){
        if (!isEmpty()){
            Object res = st[pointer];
            st[pointer--] = null;
            return res;
        }
        else
            return null;
    }

    /**
     * Метод, реализующий возврат элемента из верхушки стека
     * @return элемент верхушки стека
     */
    public Object top(){
        if (!isEmpty())
            return st[pointer];
        else
            return null;
    }

    /**
     * Метод, предназначенный для тестирования стека
     * @return массив хранения элементов стека (от верхушки до дна)
     */
    public Object[] getObjectArray() {
        Object[] res = new Object[this.pointer];
        for (int i = 0; i < pointer; i++)
            res[i] = st[pointer - 1 - i];
        return res;
    }
}
