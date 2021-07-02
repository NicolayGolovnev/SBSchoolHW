package golovnev;

/**
 * Класс, реализующий очередь (принцип FIFO)
 */
public class MyQueue {
    /**
     * Поле que - массив Object, который реализует нашу очередь. Ограничен 128 символами, предназначен для хранения
     * элементов очереди.
     */
    private final Object[] que;
    /**
     * Поле size - размер очереди, который позволяет узнать, сколько элементов у нас находятся в очереди
     */
    private int size;

    /**
     * Конструктор класса
     */
    MyQueue(){
        que = new Object[128];
        size = 0;
    }

    /**
     * Метод, реализующий добавления элемента в очередь
     * @param input добавляемый объект
     * @return 1 в случае успешного добавления, -1 в случае провала
     */
    public int enqueue(Object input){
        if (size < que.length){
            que[size++] = input;
            return 1;
        }
        else
            return -1;
    }

    /**
     * Метод, реализующий проверку на пустоту очереди
     * @return true, если очередь пуста, иначе false
     */
    public boolean isEmpty(){
        return (size == 0);
    }

    /**
     * Метод, реализующий удаление первого элемента из очереди
     * @return 1 в случае успешного удаления, -1 в случае провала
     */
    public int dequeue(){
        if (size != 0){
            System.arraycopy(que, 1, que, 0, --size);
            return 1;
        }
        else
            return -1;
    }

    /**
     * Метод, реализующий возврат первого элемента очереди
     * @return возврат 1 элемента
     */
    public Object top(){
        if (size != 0)
            return que[0];
        else
            return null;
    }

    /**
     * Метод, предназначенный для тестирования очереди
     * @return массив хранения элементов очереди (только добавленных элементов)
     */
    public Object[] getObjectArray() {
        Object[] res = new Object[this.size];
        System.arraycopy(que, 0, res, 0, size);
        return res;
    }
}
