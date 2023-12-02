package theme_5_interface.task_41;

import java.io.IOException;

public class Task_41 {
    public static void main(String[] args) {
//  1. Поймайте в дебаггере метод String.equals
        String str1 = "cat";
        System.out.println(str1.equals("cat"));
        //См. String_equals.png

//  2. Поймайте в дебаггере метод StringBuilder.equals
        StringBuilder builder1 = new StringBuilder();
        StringBuilder builder2 = new StringBuilder();
        System.out.println(builder1.equals(builder2));
        //См. StringBuilder_equals.png

//  3. Поймайте в дебаггере метод Object.equals
        Object obj1 = new Object();
        Object obj2 = new Object();
        System.out.println(obj1.equals(obj2));
        //См. Object_equals.png

//  4. В чем разница сравнения через == и через equals?
        //== сравнивает только ссылки на обьекты, а
        //equals (при его переопределении) может сравнивать значения полей обьекта

//  5. Всегда ли сравнение через equals сравнивает значения элементов?
        //Только если метод equals был переопределен со сравнением значений элементов обьектов.
        // Изначально у класса Object он сравнивает только ссылки на объекты

//  6. Реализуйте метод equals для класса FileInformation. Покажите, работает?
        FileInformation info1 = new FileInformation("file_1", "D/media/", 32);
        FileInformation info2 = new FileInformation("file_1", "D/media/", 32);
        FileInformation info3 = new FileInformation("file_3", "D/media/", 32);
        System.out.println(info1.equals(info2));
        System.out.println(info1.equals(info3));

//  7. Реализуйте метод equals для класса ITunesProduct.
        ItunesProduct product1 = ItunesProduct.findItunesProduct("Titanic", 5, "movie");
        ItunesProduct product2 = ItunesProduct.findItunesProduct("Titanic", 5, "movie");
        ItunesProduct product3 = ItunesProduct.findItunesProduct("Titanic", 5, "audiobook");
        System.out.println(product1);
        System.out.println(product2);
        System.out.println(product3);
        System.out.println(product1.equals(product2));
        System.out.println(product1.equals(product3));
//  8. Доработайте медиабраузер iTunes: он будет сохранять все найденные результаты в массив, далее давайте
     //  пользователю возможность поискать еще раз; но скрывая повторяющиеся результаты (сверяясь с массивом)
        ItunesPreviewPlayer player = new ItunesPreviewPlayer();
        try {
            player.play();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//  9. Реализуйте метод equals для класса NasaPictureInfo. Как сделать его максимально просто?
      //См. класс  NasaPictureInfo
    }
}
