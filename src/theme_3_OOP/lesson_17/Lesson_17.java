package theme_3_OOP.lesson_17;

import java.io.File;
import java.util.Arrays;

public class Lesson_17 {
    public static void main(String[] args) {
        File file1 = new File("./src/theme_3_OOP/lesson_17/myFile.txt");
        FileInformation info1 = new FileInformation();
        if (file1.exists()) {
            info1.absolutePath = file1.getAbsolutePath();
            info1.fileName = file1.getName();
            info1.size = file1.length();
        }

        File file2 = new File("./src/theme_3_OOP/lesson_17/book.txt");
        FileInformation info2 = new FileInformation();
        if (file2.exists()) {
            info2.absolutePath = file2.getAbsolutePath();
            info2.fileName = file2.getName();
            info2.size = file2.length();
        }

        FileInformation bigInfo = info1.size > info2.size ? info1 : info2;

        System.out.println("Bigger size: " + bigInfo.fileName);
        System.out.println("Path: " + bigInfo.absolutePath);
        System.out.println("Size is " + bigInfo.size);
//  -------------------------------------------------------------
        Cat cat = new Cat();
//  -------------------------------------------------------------
        File dir = new File("./src/theme_3_OOP/lesson_17/text_files");
        File[] files = dir.listFiles();
//        long[] sizes = new long[files.length];
//        String[] fileNames = new String[files.length];
//        String[] absolutePaths = new String[files.length];
        FileInformation[] fileInfos = new FileInformation[files.length];
        for (int i = 0; i < files.length; i++) {
            File currentFile = files[i];
            FileInformation info = new FileInformation();
            info.absolutePath = currentFile.getAbsolutePath();
            info.fileName = currentFile.getName();
            info.size = currentFile.length();
            fileInfos[i] = info;
//            sizes[i] = currentFile.length();
//            fileNames[i] = currentFile.getName();
//            absolutePaths[i] = currentFile.getAbsolutePath();
        }
        long maxSize = 0;
        for (int i = 0; i < fileInfos.length; i++) {
            System.out.println("file " + i + ": " + fileInfos[i].fileName);
            if (fileInfos[i].size > maxSize) {
                maxSize = fileInfos[i].size;
            }
            if (fileInfos[i].isTextFile()) {
                System.out.println("file " + fileInfos[i].fileName + " is text file");
            }
        }
        System.out.println("max file size in bytes = " + maxSize);
        
    }
}
