package theme_5_interface.lesson_43;

import theme_5_interface.lesson_42.DirectoryScanner;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CsvDirectoryScannerClass extends DirectoryScannerClass {

    public CsvDirectoryScannerClass(String directoryPath) {
        super(directoryPath);
    }

    @Override
    public void printFilesOfDirectory(File[] files) {
        try {
            FileWriter fileWriter = new FileWriter("./src/theme_5_interface/lesson_42/dir.csv");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (int i = 0; i < files.length; i++) {
                bufferedWriter.write(files[i].getName() + ";");
                if (files[i].isDirectory()) {
                    bufferedWriter.write("directory");
                } else {
                    bufferedWriter.write("file");
                }
                bufferedWriter.write("\n");
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
