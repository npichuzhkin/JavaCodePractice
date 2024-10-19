package com.npichuzhkin.javacodepractice.javastreamapi.topic6;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NumberGenerator {
    static class Order {
        private String product;
        private double cost;

        public Order(String product, double cost) {
            this.product = product;
            this.cost = cost;
        }

        public String getProduct() {
            return product;
        }

        public double getCost() {
            return cost;
        }

        @Override
        public String toString(){
            return product + " - " + cost;
        }
    }

    public static class StreamCollectorsExample {
        public static void main(String[] args) {
            List<Order> orders = List.of(
                    new Order("Laptop", 1200.0),
                    new Order("Smartphone", 800.0),
                    new Order("Laptop", 1500.0),
                    new Order("Tablet", 500.0),
                    new Order("Smartphone", 900.0));

            Map<String, List<Order>> groupedOrders = orders.stream().collect(Collectors.groupingBy(Order::getProduct));
            System.out.println("Группируем заказы по продуктам:\n" + groupedOrders);

            Map<String, Double> totalCosts = groupedOrders.entrySet().
                    stream().
                    collect(Collectors.toMap(
                            Map.Entry::getKey,
                            s -> s.getValue().
                                    stream().
                                    mapToDouble(Order::getCost).
                                    sum()));
            System.out.println("Посчитали общую стоимость для каждого продукта:\n" + totalCosts);

            Map<String, Double> sortedTotalCosts = totalCosts.entrySet()
                    .stream()
                    .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                    .collect(Collectors.toMap(
                            Map.Entry::getKey,
                            Map.Entry::getValue,
                            (e1, e2) -> e1,
                            LinkedHashMap::new
                    ));

            System.out.println("Отсортировали товары по общей стоимости:\n" + sortedTotalCosts);

            List<Order> mostExpensive = orders.stream().sorted(Comparator.comparing(Order::getCost).reversed()).limit(3).toList();
            System.out.println("Оставили 3 самых дорогих товара:\n" + mostExpensive);

            List<String> productList = mostExpensive.stream().map(Order::getProduct).toList();
            double totalCost = mostExpensive.stream().mapToDouble(Order::getCost).sum();
            System.out.println("3 самых дорогих продукта - " + productList +
                               "\nИх общая стоимость: " + totalCost);
        }
    }
}
