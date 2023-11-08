package theme_4_inheritance.task_28;

public class Task_28 {
    public static void main(String[] args) {
//  1.Что такое конструктор по-умолчанию? - это конструктор без параметров (аргументов)

//  2.Как сделать так, чтобы при каждом создании экземпляра класса, в консоль что-то выводилось? (Слежка за классом :) )
        //  Для этого нужно прописать в тело конструктора команду вывода в консоль

//  3. Сделайте класс, отображающий операционную систему; сделайте конструктор для него. Создайте несколько экземпляров
        OS ubuntu = new OS("Linux", "Ubuntu", 64, "22.04", "Canonical");
        OS windows = new OS("Windows", "Windows 10", 64, "22H2", "Microsoft");
        OS os2 = new OS("MacOS", "macOS Ventura", 64, "13.6.1", "Apple");

//  4. Сделайте класс WebSite, и несколько конструкторов для него; продемонстрируйте использование
        WebSite site1 = new WebSite();
        site1.name = "Youtube";
        site1.url = "https://www.youtube.com";
        site1.technology = "combined";
        site1.type = "video hosting";
        WebSite site2 = new WebSite("Gismeteo", "https://www.gismeteo.ru");
        WebSite site3 = new WebSite("Youtube", "https://njoore.com",
                "flash", "Content");

//  5. Создайте экземпляры StringBuilder, используя несколько конструкторов
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("I am learning");
        System.out.println(stringBuilder1);
        StringBuilder stringBuilder2 = new StringBuilder("I am programmer");
        System.out.println(stringBuilder2);
        StringBuilder stringBuilder3 = new StringBuilder(20);
        stringBuilder3.append("I'll be a programmer");
        System.out.println(stringBuilder3);

//  6.Сделайте класс Url(ссылка) с несколькими конструкторами; сделайте класс CurrencyCourse (курс валют)
        //   с несколькими конструкторами; внутри конструктора CurrencyCourse вызывайте также конструктор
        //   Url -инициализируйте ссылку, по которой будете получать курс валют; запросите курс валют.
        CurrencyCourse currencyCourse = new CurrencyCourse(1, 11, 2023,
                7, 11, 2023);
        double course = currencyCourse.setCurrencyCourse();
        System.out.println("course from " + currencyCourse.url.endDate + ": " + course);
//  7.Создайте класс TextChecker. Его конструктор принимает строку и внутри него будет происходить: Проверка текста
       //   на наличие инностранных букв вместо русской раскладки и цифр вместо нуля и буквы «з».
        //   Если обнаружена такая подмена-выбрасывается исключение
        TextChecker textChecker1 = new TextChecker("Наша Таyя громко пkачет");
        TextChecker textChecker2 = new TextChecker("0001");
        TextChecker textChecker3 = new TextChecker("3абор");
//   8. Создайте класс KeyboardSwitch. Его конструктор принимает строку и внутри него происходит:
//   Перевод текста в нужный язык(забыл переключить клавиатуру и напечатал другим языком)
        KeyboardSwitch keyboardSwitch1 = new KeyboardSwitch("Руддщ цщкдв!");
        System.out.println(keyboardSwitch1.str);
        KeyboardSwitch keyboardSwitch2 = new KeyboardSwitch("Ghjuhfvvf");
        System.out.println(keyboardSwitch2.str);
    }
}
