package pkg16;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            // Считать размер матрицы
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите размер матрицы: ");
            int n = scanner.nextInt();

            // Создать и заполнить матрицу
            int[][] matrix = new int[n][n];
            System.out.println("Введите элементы матрицы:");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            // Найти максимальный четный элемент на побочной диагонали
            int maxEven = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                int j = n - 1 - i;
                if (matrix[i][j] % 2 == 0 && matrix[i][j] > maxEven) {
                    maxEven = matrix[i][j];
                }
            }

            // Вывести максимальный четный элемент на побочной диагонали
            if (maxEven == Integer.MIN_VALUE) {
                System.out.println("Нет четных элементов на побочной диагонали.");
            } else {
                System.out.println("Максимальный четный элемент на побочной диагонали: " + maxEven);
            }
        } catch (NumberFormatException e) {
            System.out.println("Введены некорректные данные.");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Размер матрицы должен быть больше 0.");
        }
    }
}