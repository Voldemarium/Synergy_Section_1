package theme_4_inheritance.lesson_38;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Lesson_38 {
    public static void main(String[] args) {
//        JFileChooser fileChooser = new JFileChooser();
        JFileChooser fileChooser = new MyFileChooser();
        fileChooser.showOpenDialog(null);
        File file = fileChooser.getSelectedFile();
        System.out.println(file.getName());

        String[] nameParts = file.getName().split("\\.");
        String extension = nameParts[nameParts.length - 1];

        FileOpener opener;
        if (extension.equals("mp3") || extension.equals("mp4") || extension.equals("mp4a")) {
            opener = new TextFileOpener(file);
        } else if (extension.equals("txt") || extension.equals("log")) {
            opener = new MediaFileOpener(file);
        } else {
            opener = new FileOpener(file);

        }
        executeFile(opener);

    }

    public static void executeFile(FileOpener opener) {
        opener.printFileInfo();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to open file? (y/n)");
        String answer = scanner.next();
        if (answer.equals("y")) {
            opener.openFile();
        } else {
            System.out.println("Program will terminate");
        }
    }
}
