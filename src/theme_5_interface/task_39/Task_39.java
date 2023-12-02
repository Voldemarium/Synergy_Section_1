package theme_5_interface.task_39;

public class Task_39 {
    public static void main(String[] args) {
//  1. Сделайте интерфейс Decoder. В нем два метода String encode(String source) и String decode(String encoded).
   //  Реализуйте этот интерфейс: пусть класс меняет русские символы на цифры и латиницу (ш на w, г на r и так далее),
   // и наоборот
        CodeRusToEng codeRusToEng = new CodeRusToEng();
        System.out.println(codeRusToEng.encode("Паровоз"));
        System.out.println(codeRusToEng.encode("Машина"));
        System.out.println(codeRusToEng.decode("Uapobo3"));
        System.out.println(codeRusToEng.decode("Mawnha"));
//        System.out.println(codeRusToEng.decode("Mawiha"));

//  2. Сделайте ещё одну реализацию Decoder: он будет шифровать и дешифровать азбуку морзе
        CodeRusToMorse codeRusToMorse = new CodeRusToMorse();
        System.out.println(codeRusToMorse.encode("мама"));
        System.out.println(codeRusToMorse.decode("-- .- -- .-"));

//  3. Еще одну реализацию: он будет менять символ на код символа (который можно получить как (int)str.charAt))
        CodeSymbolToCode codeSymbolToCode = new CodeSymbolToCode();
        System.out.println(codeSymbolToCode.encode("мама"));
        System.out.println(codeSymbolToCode.decode("1084 1072 1084 1072"));
//  4. Доработать ConsoleTableWriter, чтобы длина левой колонки была одинаковой для всех строк и равна длине
     //  самой большой
        TableScanner tableScanner = new TableScanner();
        System.out.println("Please enter table...");
        Row[] table = tableScanner.scanTable();
        TableWriter tableWriter = new ConsoleTableWriter();
        tableWriter.writeTable(table);
    }
}
