package theme_6_data_structures.task_49;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Task_49 {
    public static void main(String[] args) {
        Set<String> set1 = getFileToSet("./src/theme_6_data_structures/task_49/article.txt");
        System.out.println("number of unique words: " + set1.size());

        String text = getTextFromFile("./src/theme_6_data_structures/task_49/article.txt");
        String textWithoutSigns = text.replaceAll("[-.—,():;?!'\"]", " ");
        System.out.println(textWithoutSigns);
        String[] words = textWithoutSigns.split(" ");
        HashSet<String> set2 = new HashSet<>(List.of(words));
        System.out.println(set2.size());
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

    static String getTextFromFile(String fileName) {
        StringBuilder builder = new StringBuilder();
        try (FileReader reader = new FileReader(fileName)) {
            int c;
            while ((c = reader.read()) != -1) {
                builder.append((char) c);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return builder.toString();
    }
}
