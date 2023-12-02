package theme_5_interface.task_40;

public class Task_40 {
    public static void main(String[] args) {
//  1. У класса FileInformation из предыдущих уроков сделайте метод toString, возвращающий информацию по всем полям.
        FileInformation info = new FileInformation();
        info.fileName = "file_1";
        info.absolutePath = "/media/vladimir/D1/";
        info.size = 32;
        System.out.println(info);

//  2. Реализуйте класс, отображающий страничку в википедии. Пусть метод toString у него возвращает текст этой странички.
        // Покажите его использование неявно, так:
        WikiPage wikiPage = new WikiPage("Java");
        System.out.println(wikiPage);

//  3. Поймайте в дебаггере метод toString у класса String
        System.out.println(('a' + "").toString());
        //См. toString_from_String.png

//  4. Поймайте в дебаггере метод toString у класса Object
        Object object = new Object();
        System.out.println(object.toString());
        //См. toString_from_Object.png

//  5. Поймайте в дебаггере метод toString у класса StringBuilder
        StringBuilder builder = new StringBuilder();
        builder.append('a');
        System.out.println(builder.toString());
        //См. toString_from_StringBuilder.png

//  6. Сделайте метод toString у класса ITunesSong, который возвращает информацию в формате xml:
        // <artist>Rick Ross</artist>... и так далее
        ITunesSong song1 = new ITunesSong("music of love", 2, false);
        System.out.println(song1);

//  7. Сделайте метод toString у класса ITunesSong, который возвращает информацию в формате JSON
        ITunesSong song2 = new ITunesSong("music of love", 2, true);
        System.out.println(song2);
    }
}
