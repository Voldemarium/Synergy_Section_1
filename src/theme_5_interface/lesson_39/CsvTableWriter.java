package theme_5_interface.lesson_39;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import static theme_5_interface.lesson_39.ConsoleTableWriter.getTab;

public class CsvTableWriter implements TableWriter, OutputFileWriter {

    @Override
    public void writeTable(Row[] table) {
        int maxLength = ConsoleTableWriter.getMaxLength(table);

        try {
            FileWriter fileWriter = new FileWriter("./src/theme_5_interface/lesson_39/files/table.csv");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Row correntRow : table) {
                StringBuilder tab1 = getTab(correntRow, maxLength);
                bufferedWriter.write(correntRow.left + tab1 + ";" + correntRow.right + "\n");
            }
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getOutputPlace() {
        return "csv file: " + "./src/theme_5_interface/lesson_39/files/table.csv";
    }

    @Override
    public String getFileName() {
        return "./src/theme_5_interface/lesson_39/files/table.csv";
    }
}
