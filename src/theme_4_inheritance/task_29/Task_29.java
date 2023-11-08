package theme_4_inheritance.task_29;


public class Task_29 {
    public static void main(String[] args) {
//  1. Добавьте конструкторы в классы: директория, файл. Самое главное, в базовый класс.
        Directory directory = new Directory("files", "D:/Java");
        File file = new File("file", "D:/Java/" + directory.name, "txt");
        file.printUrl();

//  2. Добавьте конструкторы в классы с наследованием: пользователь, администратор, модератор
        Moderator moderator = new Moderator("Vladimir", "Ivanov", 34, 7);
        moderator.printRating();

        Administrator admin = new Administrator("Vladimir", "Ivanov", 34, 5);
        admin.printWorkExperience();

//  3. Реализуйте классы с наследованием: персонаж, главный герой, злодей, друг главного героя
        MainCharacter mainCharacter = new MainCharacter("Bob", "Dilan", 35, 8);
        mainCharacter.printInfo();

        Villain villain = new Villain("Richard", "Gere", 54);
        villain.printInfo();

        FriendOfTheMainCharacter friendOfTheMainCharacter = new FriendOfTheMainCharacter(
                "Chris", "Rea", 50);
        friendOfTheMainCharacter.printInfo();
    }
}
