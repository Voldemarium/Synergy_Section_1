package theme_4_inheritance.task_34;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Task_34 {
    public static void main(String[] args) throws IOException {
//  1. Пользователь вводит 5 названий файлов. Они могут повторяться. Сохраните в каждый из файл названия ВСЕХ 5 файлов,
        // используйте try with resources
        Scanner scanner = new Scanner(System.in);
        String[] fileNames = new String[5];
        for (int i = 0; i < 5; i++) {
            System.out.println("Input file name " + (i + 1) + ": ");
            fileNames[i] = scanner.next();
        }

        for (String name : fileNames) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(
                    "./src/theme_4_inheritance/task_34/files/" + name + ".txt"))) {
                for (String fileName : fileNames) {
                    writer.write(fileName + ".txt" + "\n");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

//  2. Пользователь вводит 5 названий файлов. Сохраните в каждый из файл названия ВСЕХ 5 файлов,
        //   используйте try.. catch..finally
        String[] fileNames2 = new String[5];
        for (int i = 0; i < 5; i++) {
            System.out.println("Input file name " + (i + 1) + ": ");
            fileNames2[i] = scanner.next();
        }
        for (String name : fileNames2) {
            BufferedWriter writer = new BufferedWriter(new FileWriter(
                    "./src/theme_4_inheritance/task_34/files/" + name + ".txt"));
            try {
                for (String fileName : fileNames2) {
                    writer.write(fileName + ".txt" + "\n");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                writer.close();
            }
        }
    }
}
