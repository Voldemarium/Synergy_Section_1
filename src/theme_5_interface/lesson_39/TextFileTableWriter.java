package theme_5_interface.lesson_39;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import static theme_5_interface.lesson_39.ConsoleTableWriter.getTab;

public class TextFileTableWriter implements TableWriter, OutputFileWriter{
    String fileName;

    public TextFileTableWriter(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void writeTable(Row[] table) {
        int maxLength = ConsoleTableWriter.getMaxLength(table);

        try {
            FileWriter fileWriter = new FileWriter(this.fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Row correntRow : table) {
                StringBuilder tab1 = getTab(correntRow, maxLength);
                bufferedWriter.write(correntRow.left + tab1 +  "\t" + "|" + "\t" + correntRow.right + "\n");
            }
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getOutputPlace() {
        return "text file: " + this.fileName;
    }

    @Override
    public String getFileName() {
        return this.fileName;
    }
}
