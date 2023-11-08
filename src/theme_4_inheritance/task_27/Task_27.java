package theme_4_inheritance.task_27;

public class Task_27 {
    public static void main(String[] args) {
//  1. Реализуйте классы с наследованием: директория, файл
        Directory directory = new Directory();
        directory.name = "files";
        directory.url = "D:/Java";
        File file = new File();
        file.name = "file";
        file.url = "D:/Java/" + directory.name;
        file.fileExtension = "txt";
        file.printUrl();

//  2. Реализуйте классы с наследованием: пользователь, администратор, модератор
        Moderator moderator = new Moderator();
        moderator.firstName = "Vladimir";
        moderator.lastName = "Ivanov";
        moderator.age = 34;
        moderator.rating = 7;
        moderator.printRating();

        Administrator admin = new Administrator();
        admin.firstName = "Vladimir";
        admin.lastName = "Ivanov";
        admin.age = 34;
        admin.workExperience = 5;
        admin.printWorkExperience();

//  3. Реализуйте классы с наследованием: персонаж, главный герой, злодей, друг главного героя
        MainCharacter mainCharacter = new MainCharacter();
        mainCharacter.firstName = "Bob";
        mainCharacter.lastName = "Dilan";
        mainCharacter.age = 35;
        mainCharacter.rating = 8;
        mainCharacter.printInfo();

        Villain villain = new Villain();
        villain.firstName = "Richard";
        villain.lastName = "Gere";
        villain.age = 54;
        villain.printInfo();

        FriendOfTheMainCharacter friendOfTheMainCharacter = new FriendOfTheMainCharacter();
        friendOfTheMainCharacter.firstName = "Chris";
        friendOfTheMainCharacter.lastName = "Rea";
        friendOfTheMainCharacter.age = 50;
        friendOfTheMainCharacter.printInfo();
    }
}
