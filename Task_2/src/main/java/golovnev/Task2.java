package golovnev;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        double x, y, z;
        Scanner input = new Scanner(System.in);

        System.out.print("Введите координаты вектора a (x, y, z) через пробел: ");
        x = input.nextDouble();
        y = input.nextDouble();
        z = input.nextDouble();
        MyVector a = new MyVector(x, y, z);

        System.out.print("Введите координаты вектора b (x, y, z) через пробел: ");
        x = input.nextDouble();
        y = input.nextDouble();
        z = input.nextDouble();
        MyVector b = new MyVector(x, y, z);

        System.out.printf("Длина вектора а равна %.6f\n", a.length());
        System.out.printf("Длина вектора b равна %.6f\n", b.length());

        double scalar = a.scalar(b);
        System.out.println("Скалярное произведение двух векторов равно " + scalar);

        MyVector crossProduct = a.cross(b);
        System.out.println("Векторное произведение двух векторов: (" + crossProduct.getX() + ", " + crossProduct.getY() + ", " + crossProduct.getZ() + ")");

        double angle = a.getAngle(b);
        System.out.printf("Косинус угла между 2 векторами равен %.6f\n", angle);

        MyVector sumVector = a.plusVector(b);
        System.out.println("Сумма двух векторов равна: (" + sumVector.getX() + ", " + sumVector.getY() + ", " + sumVector.getZ() + ")");
        MyVector subVector = a.diffVector(b);
        System.out.println("Разность двух векторов равна: (" + subVector.getX() + ", " + subVector.getY() + ", " + subVector.getZ() + ")\n");

        System.out.print("Введите количество векторов, которые нужно сгенерировать случайным образом: ");
        int n = input.nextInt();
        MyVector[] array = MyVector.getRandomVectors(n);
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%d вектор из массива: (%.2f, %.2f, %.2f)\n", i + 1, array[i].getX(), array[i].getY(), array[i].getZ());
        }
    }
}
