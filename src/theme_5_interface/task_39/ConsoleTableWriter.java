package theme_5_interface.task_39;

public class ConsoleTableWriter implements TableWriter {
    @Override
    public void writeTable(Row[] table) {
        int maxLength = getMaxLength(table);

        for (Row correntRow : table) {
            StringBuilder tab1 = getTab(correntRow, maxLength);
            System.out.println(correntRow.left + tab1  + "|" + correntRow.right);
        }
    }

    public static StringBuilder getTab(Row correntRow, int maxLength) {
        StringBuilder tab1 = new StringBuilder();
        int j = 0;
        while (j < maxLength - correntRow.left.length()) {
            tab1.append(" ");
            j++;
        }
        return tab1;
    }

    public static int getMaxLength(Row[] table) {
        int maxLength = 0;
        for (Row correntRow : table) {
            if (correntRow.left.length() > maxLength) {
                maxLength = correntRow.left.length();
            }
        }
        return maxLength;
    }

    @Override
    public String getOutputPlace() {
        return "console";
    }
}
