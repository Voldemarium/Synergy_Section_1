package theme_4_inheritance.lesson_37;

import java.util.Arrays;

public class Lesson_37 {
    public static void main(String[] args) {
        m1();
    }

    public static void m1() {
        System.out.println("1");
        m2();
    }

    public static void m2() {
        System.out.println("2");
        m3(4);
    }

    public static void m3(int m3x) {
        int m3y = 2;
        System.out.println("3");
        m4();
    }

    public static void m4() {
        System.out.println("4");
        m5();
    }

    public static void m5() {
        System.out.println("5");
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        for (StackTraceElement element : stackTrace) {
            System.out.println(element);
        }
    }
}
