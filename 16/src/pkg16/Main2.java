package pkg16;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        try {
            // Считать размер матрицы
            int n = readSize();

            // Создать и заполнить матрицу
            int[][] matrix = createMatrix(n);

            // Найти максимальный четный элемент на побочной диагонали
            int maxEven = findMaxEvenOnSecondaryDiagonal(matrix);

            // Вывести максимальный четный элемент на побочной диагонали
            printResult(maxEven);
        } catch (NumberFormatException e) {
            System.out.println("Введены некорректные данные.");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Размер матрицы должен быть больше 0.");
        }
    }

    private static int readSize() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер матрицы: ");
        return scanner.nextInt();
    }

    private static int[][] createMatrix(int n) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = new int[n][n];
        System.out.println("Введите элементы матрицы:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }

    private static int findMaxEvenOnSecondaryDiagonal(int[][] matrix) {
        int maxEven = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            int j = matrix.length - 1 - i;
            if (matrix[i][j] % 2 == 0 && matrix[i][j] > maxEven) {
                maxEven = matrix[i][j];
            }
        }
        return maxEven;
    }

    private static void printResult(int maxEven) {
        if (maxEven == Integer.MIN_VALUE) {
            System.out.println("Нет четных элементов на побочной диагонали.");
        } else {
            System.out.println("Максимальный четный элемент на побочной диагонали: " + maxEven);
        }
    }
}