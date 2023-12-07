package theme_6_data_structures.lesson_50;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Lesson_50 {
    public static void main(String[] args) {
        TreeSet<String> treeSet = new TreeSet<>(getFileToSet("./src/theme_6_data_structures/task_49/article.txt"));
        System.out.println(treeSet);

        TreeSet<Integer> treeSet1 = new TreeSet<>();
        treeSet1.add(1);
        treeSet1.add(10);
        treeSet1.add(3);
        treeSet1.add(7);
        treeSet1.add(2);
        System.out.println(treeSet1);
        //Методы из интерфейса SortedSet:
        System.out.println(treeSet1.tailSet(3)); //вернет все значения выше или равно (>=) fromElement
        System.out.println(treeSet1.headSet(3)); //вернет все значения левее (<) toElement
        //Методы из интерфейса NavigableSet:
        System.out.println(treeSet1.floor(3)); //вернет max из тех значений, что меньше или равно (<=) e
        System.out.println(treeSet1.ceiling(3)); //вернет min из тех значений, что выше или равно (>=) e
        System.out.println(treeSet1.lower(3)); //вернет max из тех значений, что меньше (<) e
        System.out.println(treeSet1.higher(3)); //вернет min из тех значений, что выше (>) e






    }
    private static Set<String> getFileToSet(String fileName) {
        Set<String> set = new HashSet<>();
        try (FileReader fileReader = new FileReader(fileName)) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String lineMod = line.replaceAll("[-.—,():;?!'\"]", " ");
                String[] strArray = lineMod.split(" ");
                Collections.addAll(set, strArray);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return set;
    }
}
