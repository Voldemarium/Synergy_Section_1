package theme_6_data_structures.lesson_52;

import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeMap;

public class Lesson_52 {
    public static void main(String[] args) {
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("Petya", 4); // put() добавляет ключ и значение (если пусто) или перезаписывает значение
        treeMap.put("John", 5);
        treeMap.put("Vova", 4);
        System.out.println(treeMap);

        TreeMap<Integer, Person> treeMap2 = new TreeMap<>();
        treeMap2.put(1, new Person("Sasha", 6));
        treeMap2.put(2, new Person("Masha", 3));
        treeMap2.put(3, new Person("Andrey", 5));
        System.out.println(treeMap2);

        //Для того, чтобы использовать объекты в качестве ключа в TreeMap, они должны быть сравниваемыми
        //(Иметь интерфейс Comparable<Person> или передать в конструктор TreeMap Comparator)
        TreeMap<Person, Integer> treeMap3 = new TreeMap<>(Comparator.comparing(person -> person.name));
        treeMap3.put(new Person("Sasha", 6), 6);
        treeMap3.put(new Person("Masha", 3), 3);
        treeMap3.put(new Person("Andrey", 5), 5);
        System.out.println(treeMap3);
    }
}
