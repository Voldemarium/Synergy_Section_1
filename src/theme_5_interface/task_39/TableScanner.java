package theme_5_interface.task_39;

import java.util.Scanner;

public class TableScanner {
    public Row[] scanTable() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("please enter header, left column");
        String headerLeft = scanner.next();
        System.out.println("please enter header, right column");
        String headerRight = scanner.next();
        Row header = new Row(headerLeft, headerRight);
        System.out.println("How many rows will have in the table?");
        int rowsCount = scanner.nextInt();

        Row[] table = new Row[rowsCount + 1];
        table[0] = header;

        for (int i = 1; i <= rowsCount; i++) {
            System.out.println("Enter " + i  + " row:");
            System.out.println("please enter left column:");
            String left = scanner.next();
            System.out.println("please enter right column:");
            String right = scanner.next();
            Row row = new Row(left, right);
            table[i] = row;
        }
        return table;
    }

}
