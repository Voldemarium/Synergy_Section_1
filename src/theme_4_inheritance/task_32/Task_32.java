package theme_4_inheritance.task_32;

import theme_4_inheritance.task_32.exceptions.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

public class Task_32 {
    public static void main(String[] args) {
//  1. Доработайте крестики-нолики; создайте исключение, которое будете бросать при неверном вводе пользователя
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.startPlay();
//  2. Доработайте калькулятор: при неверном вводе выбрасывайте исключение
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter number int x: ");
//        int x = scanner.nextInt();
//        System.out.println("Enter operator: ");
//        char operator = scanner.next().charAt(0);
//        System.out.println("Enter number int y: ");
//        int y = scanner.nextInt();
        Calculator calculator = new Calculator();
        System.out.println("result = " + calculator.getResult());
//  3. Аналогичным образом, доработайте запрос курса валют на дату: при некорректном вводе бросайте исключение.
    // При отсутствии курса валют в ответе, бросайте другое исключение.
        System.out.println("Enter start date: ");
        LocalDate localDate1 = getInputLocalDate();
        System.out.println("Enter end date: ");
        LocalDate localDate2 = getInputLocalDate();
        if (localDate2.isBefore(localDate1)) {
            throw new IncorrectInputException(" End date before start date!");
        }
        DatePeriod datePeriod = new DatePeriod(localDate1, localDate2);
        CurrencyCourse currencyCourse = new CurrencyCourse(datePeriod);
        String[][] courses = currencyCourse.setCurrencyCourse();
        for (String[] course : courses) {
            System.out.println(Arrays.toString(course));
        }

//  4. Создайте 10 классов-исключений. Соберите их в массив. Пусть пользователь выбирает,
     //  какое по счету исключение выбросить.
        Scanner scanner = new Scanner(System.in);
     RuntimeException[] exceptions = new RuntimeException[] {new Exception_1(), new Exception_2(), new Exception_3(),
                new Exception_4(), new Exception_5(), new Exception_6(), new Exception_7(),
                new Exception_8(), new Exception_9(), new Exception_10()};
        getChoseException(scanner, exceptions);

//   5. Соберите их в матрицу 3х3. Пусть пользователь выбирает номер столбца и строки, какое выбросить исключение.
    // Если ввод неверный-выбросите десятое.
        RuntimeException[][] exceptions_arrays = new RuntimeException[3][3];
        int k = 0;
        for (int i = 0; i < exceptions_arrays.length; i++) {
            for (int j = 0; j < exceptions_arrays[i].length; j++) {
                exceptions_arrays[i][j] = exceptions[k];
                k++;
            }
        }
        getChoseExceptionOfArrays(scanner, exceptions_arrays);

//  6. Сделайте функцию, которая возвращает случайное исключение из этих 10 (тип возвращаемого значения будет общий:
        // Exception). Выбросите это случайное исключение
     throw  getRandomException(exceptions);

    }

    private static void getChoseException(Scanner scanner, RuntimeException[] exceptions) {
        System.out.println("Chose exception 1-10: ");
        int exceptionNumber = scanner.nextInt();
        if (exceptionNumber < 1 || exceptionNumber > 10) {
            throw new  IncorrectInputException("exception number not between 1 and 10!");
        }
        throw exceptions[exceptionNumber - 1];
    }

    private static void getChoseExceptionOfArrays(Scanner scanner, RuntimeException[][] exceptions) {
        System.out.println("Chose exception from row 1 - 3: ");
        int row = scanner.nextInt();
        if (row < 1 || row > 3) {
            throw new Exception_10 ();
        }
        System.out.println("Chose exception from column 1 - 3: ");
        int col = scanner.nextInt();
        if (col < 1 || col > 3) {
            throw new Exception_10();
        }
        throw exceptions[row - 1][col - 1];
    }

    private static RuntimeException getRandomException(RuntimeException[] exceptions) {
        int exceptionNumber = (int) (Math.random() * 10) + 1;
        return exceptions[exceptionNumber - 1];
    }

    static LocalDate getInputLocalDate() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter year: ");
        int year = scanner.nextInt();
        if (year > 2024 || year < 1990) {
            throw new IncorrectInputException(" Year should be between 1990 and 2024");
        }
        System.out.println("Enter month: ");
        int month = scanner.nextInt();
        if (month < 1 || month > 12) {
            throw new IncorrectInputException(" Month should be between 1 and 12");
        }
        System.out.println("Enter day: ");
        int day = scanner.nextInt();
        if (day < 1 || day > 31) {
            throw new IncorrectInputException(" Day of month should be between 1 and 31");
        }
        return LocalDate.of(year, month, day);
    }
}
