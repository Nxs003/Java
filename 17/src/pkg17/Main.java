package pkg17;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        // Инициализация списка продуктов
        List<Product> products = new ArrayList<>();
        products.add(new Product("Молоко", "Милком", 10, 1.5));
        products.add(new Product("Хлеб", "Хлебозавод №1", 20, 0.7));
        products.add(new Product("Яблоки", "Фруктовый сад", 15, 2.0));
        products.add(new Product("Апельсины", "Цитрус", 25, 3.5));
        products.add(new Product("Мясо", "Мясной цех", 12, 10.0));

        // Определение товара с максимальным количеством единиц
        Product productWithMaxQuantity = products.stream()
                .max(Comparator.comparing(Product::getQuantity))
                .orElseThrow(() -> new RuntimeException("Нет товаров в списке"));
        System.out.println("Товар с максимальным количеством единиц: " + productWithMaxQuantity);

        // Упорядочивание списка по убыванию цен товаров
        List<Product> sortedProducts = products.stream()
                .sorted(Comparator.comparingDouble(Product::getPrice).reversed())
                .collect(Collectors.toList());
        System.out.println("\nСписок упорядоченный по убыванию цен:");
        sortedProducts.forEach(System.out::println);

        // Удаление записей с одинаковыми полями Наименование, производитель
        List<Product> uniqueProducts = products.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("\nСписок с удаленными дубликатами:");
        uniqueProducts.forEach(System.out::println);

        // Поиск по наименованию товара
        String productName = "Яблоки";
        Product foundProduct = products.stream()
                .filter(p -> p.getName().equals(productName))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Товар с заданным названием не найден"));
        System.out.println("\nНайденный товар:");
        System.out.println(foundProduct);

        // Исправление одного из полей и вывод полной информации о товаре после редактирования
        foundProduct.setPrice(3.0);
        System.out.println("\nТовар после редактирования:");
        System.out.println(foundProduct);
    }
}