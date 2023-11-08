package theme_4_inheritance.task_36;

public class Task_36 {
    public static void main(String[] args) {
//  1. Выбросите NPE
//        throw new NullPointerException();

//  2. Напишите код, в котором будет выброшен нпе, при этом не используется throw
        String str = null;
        str.charAt(0);

//  3. Как уберечься от NPE
    // делаем провеку на null:
       if (str != null) {
           str.charAt(0);
       }

//  4. Что такое null?
   //  null = это отсутвие какого-либа значения пустая ссылка (на несуществующий объект)

//  5. Создайте массив nullов
     String[] str1 = new String[] {null, null, null, null, null};

//  6.Выведите сумму nullов
     // null - это пустая ссылка на обьект, обьекты не складываются (можно только, например склеить строки или
     // сложить какие то примитивные поля у объекта (но т.к. объекта не существует, при обращении к нему будет
     // выброшен NPE
        System.out.println(str1[0] + str1[1] + str1[2]);
    }
}
