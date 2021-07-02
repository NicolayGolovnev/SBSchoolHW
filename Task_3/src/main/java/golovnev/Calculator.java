package golovnev;

import java.util.Scanner;

public class Calculator {
    /**
     * Метод, которое вычисляет заданное выражение
     * @param numbers массив из 2 чисел
     * @param operator заданный оператор
     * @return число, вычисляемое по заданному оператору
     */
    public static double calculate(double[] numbers, char operator){
        return switch (operator) {
            case '+' -> plus(numbers[0], numbers[1]);
            case '-' -> diff(numbers[0], numbers[1]);
            case '*' -> multiply(numbers[0], numbers[1]);
            case '/' -> div(numbers[0], numbers[1]);
            case '%' -> mod(numbers[0], numbers[1]);
            default -> -1;
        };
    }

    /**
     * Метод, который выполняет сложение двух чисел
     * @param a первое число
     * @param b второе число
     * @return сложение двух чисел
     */
    private static double plus(double a, double b){
        return a + b;
    }

    /**
     * Метод, который выполняет вычитание второго числа из первого
     * @param a первое число
     * @param b второе число
     * @return вычитание чисел
     */
    private static double diff(double a, double b){
        return a - b;
    }

    /**
     * Метод, который выполняет произведение двух заданных чисел
     * @param a первое число
     * @param b второе число
     * @return произведение двух чисел
     */
    private static double multiply(double a, double b){
        return a * b;
    }

    /**
     * Метод, который выполняет деление одного числа на другое
     * @param a первое число
     * @param b второе число
     * @return результат деления
     */
    private static double div(double a, double b){
        return a / b;
    }

    /**
     * Метод, который возвращает остаток от деления двух чисел
     * @param a первое число
     * @param b второе число
     * @return остаток от деления
     */
    private static double mod(double a, double b){
        return a % b;
    }

    public static void main(String[] args) {
        final Scanner input = new Scanner(System.in);
        double[] numbers = new double[2];

        String condition;
        do {
            System.out.print("\nВведите выражение, которое необходимо вычислить (например, 1 + 1): ");
            numbers[0] = input.nextDouble();
            char operator = input.next().charAt(0);
            numbers[1] = input.nextDouble();

            double result = Calculator.calculate(numbers, operator);
            String resultString;
            if (result != -1)
                resultString = String.format("%.2f %c %.2f = %.2f", numbers[0], operator, numbers[1], result);
            else
                resultString = "Невозможно вычислить выражение, попробуйте еще раз!";
            System.out.println(resultString);

            System.out.print("Продолжаем вычисления? (да/нет) ");
            condition = input.next();
        } while (condition.equalsIgnoreCase("да"));
    }
}
