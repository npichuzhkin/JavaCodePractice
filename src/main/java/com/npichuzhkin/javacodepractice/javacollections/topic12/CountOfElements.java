package com.npichuzhkin.javacodepractice.javacollections.topic12;

import java.util.HashMap;
import java.util.Map;

public class CountOfElements {

    public static void main(String[] args) {
        String[] namesArrayForTest = {"Alice", "Isaac", "Isaac", "Charlie", "David",
                "Bob", "Hannah", "Alice", "Frank", "Eve",
                "Hannah", "Frank", "Bob", "Jack", "Charlie",
                "David", "Grace", "Charlie", "David", "Frank"};

        System.out.println(countElements(namesArrayForTest));
    }

    public static <K> Map<K, Integer> countElements(K[] array){
        Map<K, Integer> map = new HashMap<>();

        for (K key: array) {
            int currentValue = 1;
            if (map.containsKey(key)) currentValue = map.get(key) + 1;
            map.put(key, currentValue);
        }

        return map;
    }
}
