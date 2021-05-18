package CompMath5.InputOutput;

import CompMath5.Computations.Functions;

import java.util.Scanner;

public class InputConsole {
    Scanner in = new Scanner(System.in);

    public int methodInput() {
        System.out.println("""
                Выберете действие:
                1. Ввод своей таблицы данных
                2. Ввод данных на основаниии выбранной функции
                3. Выход из программы
                """);
        try {
            return Integer.parseInt(in.next().trim());
        } catch (NumberFormatException ignored) {
            System.out.println("Ошибка ввода!");
            return methodInput();
        }
    }

    public int functionSelection() {
        System.out.println("""
                Выберете функцию:
                1. sin(x)
                2. x^2 + 3*x - 2
                3. 3^x - x^2 + 2*x
                """);
        try {
            int functionNumber = Integer.parseInt(in.next().trim());
            if (functionNumber > 0 && functionNumber <= 3) {
                return functionNumber;
            } else {
                System.out.println("Ошибка ввода!");
                return functionSelection();
            }
        } catch (NumberFormatException ignored) {
            System.out.println("Ошибка ввода!");
            return functionSelection();
        }
    }

    public double[][] inputPointX(int functionNumber) {
        Functions f = new Functions();
        int n = inputN();
        double[][] points = new double[2][n];

        for (int i = 0; i < n; i++) {
            while (true) {
                points[0][i] = inPointX("Введите координату X" + (i + 1) + ": ");
                if (findPoint(i, points, points[0][i])) {
                    break;
                } else {
                    System.out.println("Такой X уже присутствует в выборке");
                }
            }
            points[1][i] = f.f(points[0][i], functionNumber);
        }

        return points;
    }

    private boolean findPoint(int n, double[][] points, double point) {
        for (int i = 0; i < n; i++) {
            if (points[0][i] == point)
                return false;
        }
        return true;
    }

    public double[][] inputPoints() {
        int n = inputN();
        double[][] points = new double[2][n];

        for (int i = 0; i < n; i++) {
            while (true) {
                points[0][i] = inPointX("Введите координату X" + (i + 1) + ": ");
                if (findPoint(i, points, points[0][i])) {
                    break;
                } else {
                    System.out.println("Такой X уже присутствует в выборке");
                }
            }
            points[1][i] = inPointY(i);
        }

        return points;
    }

    private int inputN() {
        System.out.print("Введите колиичество точек: ");
        try {
            return Integer.parseInt(in.next().trim());
        } catch (NumberFormatException ignored) {
            System.out.println("Ошибка ввода!");
            return inputN();
        }
    }

    public double inPointX(String msg) {
        System.out.print(msg);
        try {
            return Double.parseDouble(in.next().trim().replaceAll(",", "\\."));
        } catch (NumberFormatException ignored) {
            System.out.println("Ошибка ввода!");
            return inPointX(msg);
        }
    }

    private double inPointY(int index) {
        System.out.print("Введите координату Y" + (index + 1) + ": ");
        try {
            return Double.parseDouble(in.next().trim().replaceAll(",", "\\."));
        } catch (NumberFormatException ignored) {
            System.out.println("Ошибка ввода!");
            return inPointY(index);
        }
    }
}