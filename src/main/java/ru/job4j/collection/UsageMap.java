package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("ivanov@mail.ru", "Ivanov Ivan Ivanovich");
        map.put("petrov@mail.ru", "Petrov Petr Ivanovich");
        map.put("sidorov@mail.ru", "Sidorov Petr Ivanovich");
        map.put("vasiliy@mail.ru", "Sidorov Vasiliy Ivanovich");
        map.put("ivanov@mail.ru", "Ivanov Petr Ivanovich");
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " " + value);
        }
    }
}
