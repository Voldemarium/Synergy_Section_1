package theme_6_data_structures.lesson_51;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lesson_51 {
    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap<>();

        hashMap.put("Petya", 4); // put() добавляет ключ и значение (если пусто) или перезаписывает значение
        hashMap.put("John", 5);
        hashMap.put("Vova", 4);
        System.out.println(hashMap);

        hashMap.putIfAbsent("Masha", 5); // putIfAbsent() добавляет элемент со значением (если этого ключа не было)
        System.out.println(hashMap);

        hashMap.replace("John", 3); // перезаписывает значение, если такой ключ есть
        System.out.println(hashMap);

        hashMap.remove("Masha"); // удаляет элемент по ключу
        System.out.println(hashMap);

        if (hashMap.containsKey("John")) {  // проверка наличия элемента по ключу
            System.out.println(hashMap.get("John"));  // значение из элемента по ключу
        }

        for (Map.Entry<String, Integer> entry  : hashMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue()); ;
        }

//  ---------------------------------
        //В качестве ключа в HashMap можно использовать так же и свой класс, хешкод назначается у объектов
        // автоматически, но можно и переопределить
        HashMap<Student, Integer> hashMap2 = new HashMap<>();
        hashMap2.put(new Student("Petya", 4), 1); // put() добавляет ключ и значение (если пусто) или перезаписывает значение
        hashMap2.put(new Student("John", 5), 2); // put() добавляет ключ и значение (если пусто) или перезаписывает значение
        hashMap2.put(new Student("Vova", 4), 1); // put() добавляет ключ и значение (если пусто) или перезаписывает значение
        System.out.println(hashMap2);
        System.out.println(new Student("Petya", 4).hashCode());
        System.out.println(new Student("Petya", 4).hashCode());
        System.out.println(new Student("Petya", 4).hashCode());



    }
}
