package pkg17;


import java.util.Arrays;

public class Main2 {

    public static void main(String[] args) {
        // Инициализация массива продуктов
        Product[] products = new Product[]{
                new Product("Молоко", "Милком", 10, 1.5),
                new Product("Хлеб", "Хлебозавод №1", 20, 0.7),
                new Product("Яблоки", "Фруктовый сад", 15, 2.0),
                new Product("Апельсины", "Цитрус", 25, 3.5),
                new Product("Мясо", "Мясной цех", 12, 10.0)
        };

        // Определение товара с максимальным количеством единиц
        Product productWithMaxQuantity = Arrays.stream(products)
                .max(Product::compareTo)
                
                .orElseThrow(() -> new RuntimeException("Нет товаров в массиве"));
        System.out.println("Товар с максимальным количеством единиц: " + productWithMaxQuantity);

        // Упорядочивание списка по убыванию цен товаров
        Arrays.sort(products, (p1, p2) -> Double.compare(p2.getPrice(), p1.getPrice()));
        System.out.println("\nСписок упорядоченный по убыванию цен:");
        Arrays.stream(products).forEach(System.out::println);

        // Удаление записей с одинаковыми полями Наименование, производитель
        Product[] uniqueProducts = Arrays.stream(products)
                .distinct()
                .toArray(Product[]::new);
        System.out.println("\nСписок с удаленными дубликатами:");
        Arrays.stream(uniqueProducts).forEach(System.out::println);

        // Поиск по наименованию товара
        String productName = "Яблоки";
        Product foundProduct = Arrays.stream(products)
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