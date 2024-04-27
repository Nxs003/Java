package pkg15;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Создаем мапу, в которой ключом является судовладелец, а значением - список судов
        Map<String, Ship[]> ships = new HashMap<>();

        // Добавляем несколько судов в мапу
        ships.put("Иван Иванов", new Ship[] {
                new Ship("Грузовое", 1000, 10000, 200),
                new Ship("Пассажирское", 500, 5000, 150)
        });
        ships.put("Петр Петров", new Ship[] {
                new Ship("Танкер", 2000, 15000, 250),
                new Ship("Рыболовное", 300, 3000, 100)
        });

        // 1. Определяем и выводим размер мапы
        System.out.println("Размер мапы: " + ships.size());

        // 2. Выводим одну пару по ключу
        System.out.println("Суда судовладельца Иван Иванов:");
        for (Ship ship : ships.get("Иван Иванов")) {
            System.out.println(ship);
        }

        // 3. Изменяем значение одного или нескольких полей в объекте класса
        ships.get("Иван Иванов")[0].setCarryingCapacity(1200);

        // 4. Определяем количество ключей у интересующего объекта (ключ вводится с консоли)
        System.out.print("Введите имя судовладельца: ");
        String shipownerName = scanner.nextLine();
        System.out.println("Количество ключей у судовладельца " + shipownerName + ": " + ships.get(shipownerName).length);

        // 5. Изменяем у этого же объекта одно поле класса
        ships.get(shipownerName)[0].setDailyMaintenanceCost(12000);

        // 6. Выводим мару в читаемом виде с порядковыми номерами
        int i = 1;
        for (Map.Entry<String, Ship[]> entry : ships.entrySet()) {
            System.out.println("Судовладелец: " + entry.getKey());
            for (Ship ship : entry.getValue()) {
                System.out.println(i++ + ". " + ship);
            }
            System.out.println();
        }

        // 7. Дополнительное задание: Определить общую стоимость содержания судов интересующего судовладельца за навигацию
        double totalMaintenanceCost = 0;
        for (Ship ship : ships.get(shipownerName)) {
            totalMaintenanceCost += ship.getDailyMaintenanceCost() * ship.getNavigationDuration();
        }
        System.out.println("Общая стоимость содержания судов судовладельца " + shipownerName + " за навигацию: " + totalMaintenanceCost);
    }
}