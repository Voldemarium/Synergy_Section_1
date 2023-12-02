package theme_5_interface.lesson_39;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class HtmlTableWriter implements TableWriter, OutputFileWriter{

    @Override
    public void writeTable(Row[] table) {
        try {
            FileWriter fileWriter = new FileWriter("./src/theme_5_interface/lesson_39/files/table.html");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

//  <table> </table> - начало и конец таблицы (border=1 - это отображение границ таблицы)
//  <b>  </b> - начало и конец жирного шрифта
//  <td> </td> - начало и конец столбца
//  <tr> </tr> - начало и конец строки
            bufferedWriter.write("<table border=1><b><td>");
            Row header = table[0];
            bufferedWriter.write(header.left);
            bufferedWriter.write("</td><td>");
            bufferedWriter.write(header.right);
            bufferedWriter.write("</td><tr></b>");
            for (int i = 1; i < table.length; i++) {
                Row correntRow = table[i];
                bufferedWriter.write("<tr><td>" + correntRow.left + "</td><td>" + correntRow.right + "</td></tr>");
            }
            bufferedWriter.write("</table>");
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getOutputPlace() {
        return "html file: " + "./src/theme_5_interface/lesson_39/files/table.html";
    }

    @Override
    public String getFileName() {
        return "./src/theme_5_interface/lesson_39/files/table.html";
    }
}
