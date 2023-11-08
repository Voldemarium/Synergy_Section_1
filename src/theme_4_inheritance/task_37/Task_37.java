package theme_4_inheritance.task_37;

import java.util.Arrays;

public class Task_37 {
    public static void main(String[] args) {
//  1. Что такое stacktrace?
        //Это последовательно цепочка вызовов, представленная как стопка вызовов методов по порядку снизу вверх
        //Используется для отслеживание работы программы (например при возникновении исключений)

//  2. Выведите stacktrace
      m1();

//  3. Какой самый простой способ проследить цепочку вызовов конкретного метода?
        //в этом методе вызвать Thread.currentThread().getStackTrace()
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        for (StackTraceElement element : stackTrace) {
            System.out.println(element);
        }

//  4. второй способ?
//     выбросить в этом методе исключение, после его срабатывания увидим цепочку вызовоа в консоли

    }
    public static void m1() {
        System.out.println("1");
        m2();
    }

    public static void m2() {
        System.out.println("2");
        m3(null);
    }

    public static void m3(String str) {
        System.out.println(str.length());
    }
}
