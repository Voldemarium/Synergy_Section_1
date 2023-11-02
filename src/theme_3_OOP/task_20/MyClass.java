package theme_3_OOP.task_20;

public class MyClass {
    String task;

    public void solution () {
        if (this.task.equals("найти минимум из 2 чисел")) {
            System.out.println("int min = Math.min(int a, int b);");
        } else if (this.task.equals("найти сумму элементов массива")) {
            System.out.println("int[] array = new int[]{1, 2, 3};\n" +
                               "int sum = 0;\n" +
                               "for (int j : array) {\n" +
                               "sum += j;\n" +
                               "}");
        } else if (this.task.equals("вывести строку с конца")) {
            System.out.println("String str = \"I will be a programmer\";\n" +
                               "char[] chars = str.toCharArray();\n" +
                               "for (int i = chars.length - 1; i >= 0 ; i--) {\n" +
                               "System.out.print(chars[i]);\n" +
                               "}");
        } else {
            System.out.println("unknown task");
        }
    }
}
