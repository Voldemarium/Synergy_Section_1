package theme_5_interface.lesson_39;

import java.io.*;

public class Lesson_39 {
    public static void main(String[] args) throws IOException {
        TableScanner tableScanner = new TableScanner();
        System.out.println("Please enter table...");
        Row[] table = tableScanner.scanTable();
        TableWriter tableWriter = new ConsoleTableWriter();
        tableWriter.writeTable(table);
//        TableWriter tableWriter = new TextFileTableWriter("./src/theme_5_interface/lesson_39/files/table.txt");
//        tableWriter.writeTable(table);
//        CsvTableWriter tableWriter = new CsvTableWriter();
//        tableWriter.writeTable(table);
//        TableWriter tableWriter = new HtmlTableWriter();
//        tableWriter.writeTable(table);
        System.out.println("table written to ..." + tableWriter.getOutputPlace());
//        readFile(tableWriter);
    }

    public static void readFile(OutputFileWriter writer) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(writer.getFileName()));
        String next = reader.readLine();
        while (next != null) {
            System.out.println(next);
            next = reader.readLine();
        }
    }
}
