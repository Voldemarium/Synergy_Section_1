package theme_4_inheritance.task_35;

public class Task_35 {
    public static void main(String[] args) {
// 1. Чем отличаются checked и unchecked исключения
        //checked исключения наследуются от Exception, должны быть обязательно обработаны с помощью try catch, либо проброшены с выше с
        // помощью throws, иначе программа не будет скомпилирована
        //unchecked исключения наследуются от RuntimeException, не подлежат обязательной обработке, программа скомпилируется
//  2. Создайте проверяемое и непроверяемое исключение
        MyException myException = new MyException();
        MyRuntimeException myRuntimeException = new MyRuntimeException();
//  3. Создайте 10 checked и 10 unchecked исключений. Сделайте два массива с ними
        Exception[] checkedExceptions = new Exception[]{new MyException1(), new MyException2(), new MyException3(),
                new MyException4(), new MyException5(), new MyException6(), new MyException7(), new MyException8(),
                new MyException9(), new MyException10()};
        RuntimeException[] uncheckedExceptions = new RuntimeException[]{new MyRuntimeException1(),
                new MyRuntimeException2(), new MyRuntimeException3(), new MyRuntimeException4(),
                new MyRuntimeException5(), new MyRuntimeException6(), new MyRuntimeException7(),
                new MyRuntimeException8(), new MyRuntimeException9(), new MyRuntimeException10()};

//  4. Сделайте метод, который возвращает из этих массивов случайный элемент; иногда из первого, иногда из второго.
        // Какой тип данных будет возвращать этот метод?
        System.out.println(getException(checkedExceptions, uncheckedExceptions).getMessage());

//  5. Нарисуйте иерархию классов exception и runtime exception до самого начала
     //см. Hierarchy.jpg
    }

    static public Exception getException(Exception[] exceptions, RuntimeException[] runtimeExceptions) {
        int number = (int) (Math.random() * 20 + 1);
        if (number <= 10) {
            return exceptions[number - 1];
        } else {
            return runtimeExceptions[number - 11];
        }
    }
}
