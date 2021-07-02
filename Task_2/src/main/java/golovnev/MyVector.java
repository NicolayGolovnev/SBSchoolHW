package golovnev;

/**
 * Класс, описывающий вектор (в трехмерном пространстве)
 */
public final class MyVector {
    private final double x, y, z;

    /**
     * Конструктор класса с 3 входными параметрами
     *
     * @param x координата x
     * @param y координата y
     * @param z координата z
     */
    MyVector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Геттер параметра x
     *
     * @return координата x
     */
    public double getX() {
        return x;
    }

    /**
     * Геттер параметра y
     *
     * @return координата y
     */
    public double getY() {
        return y;
    }

    /**
     * Геттер параметра z
     *
     * @return координата z
     */
    public double getZ() {
        return z;
    }

    /**
     * Метод, вычисляющий длину вектора
     *
     * @return длина вектора
     */
    public double length() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    /**
     * Метод, вычисляющий скалярное произведение
     *
     * @param vec второй вектор, участвующий в вычислениях
     * @return скалярное произведение 2 векторов
     */
    public double scalar(MyVector vec) {
        return (x * vec.getX() + y * vec.getY() + z * vec.getZ());
    }

    /**
     * Метод, вычисляющий векторное произведение
     *
     * @param vec второй вектор, участвующий в вычислениях
     * @return новый вектор с полученными координатами из векторного произведения
     */
    public MyVector cross(MyVector vec) {
        double x = this.y * vec.getZ() - this.z * vec.getY();
        double y = this.z * vec.getX() - this.x * vec.getZ();
        double z = this.x * vec.getY() - this.y * vec.getX();

        return new MyVector(x, y, z);
    }

    /**
     * Метод, вычисляющий угол между векторами (косинус угла)
     *
     * @param vec второй вектор, участвующий в вычислениях
     * @return косинус угла между двумя векторами
     */
    public double getAngle(MyVector vec) {
        return this.scalar(vec) / (this.length() * vec.length());
    }

    /**
     * Метод для суммирования двух векторов
     *
     * @param vec второй вектор, участвующий в вычислениях
     * @return новый вектор с полученными координатами
     */
    public MyVector plusVector(MyVector vec) {
        double x = this.x + vec.getX();
        double y = this.y + vec.getY();
        double z = this.z + vec.getZ();

        return new MyVector(x, y, z);
    }

    /**
     * Метод для разности двух векторов
     *
     * @param vec второй вектор, участвующий в вычислениях
     * @return новый вектор с полученными координатами
     */
    public MyVector diffVector(MyVector vec) {
        double x = this.x - vec.getX();
        double y = this.y - vec.getY();
        double z = this.z - vec.getZ();

        return new MyVector(x, y, z);
    }

    /**
     * Статический метод, который создает массив размера N случайных векторов с координатами от 0 до 10
     *
     * @param n размер массива случайных векторов
     * @return массив случайных векторов размером N
     */
    public static MyVector[] getRandomVectors(int n) {
        MyVector[] result = new MyVector[n];
        for (int i = 0; i < n; i++) {
            double x = Math.random() * 10;
            double y = Math.random() * 10;
            double z = Math.random() * 10;
            result[i] = new MyVector(x, y, z);
        }
        return result;
    }
}
