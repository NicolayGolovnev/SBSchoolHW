package golovnev;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Введите 2 числа: ");
        int num1 = input.nextInt();
        int num2 = input.nextInt();

        System.out.print("Минимум среди двух чисел равен ");
        System.out.println(Math.min(num1, num2));
    }
}
