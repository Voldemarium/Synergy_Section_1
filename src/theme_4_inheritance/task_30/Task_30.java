package theme_4_inheritance.task_30;

public class Task_30 {
    public static void main(String[] args) {
//  1. Почему наследник всегда можно преобразовать к родителю?
      //Потому что у наследника в обязательном порядке содержаться те же члены класса, как у родителя
//  2. Реализуйте метод, который выводит имя пользователя. Передайте в этот метод также и модератора, и админа
        User user = new User("Olya", "Ivanova", 22);
        User.printNameUser(user);
        Moderator moderator = new Moderator("Vladimir", "Ivanov", 34, 7);
        User.printNameUser(moderator);
        Administrator admin = new Administrator("Konstantin", "Sobolev", 37, 5);
        User.printNameUser(admin);
//  3. Возможно ли преобразовать родителя к наследнику? Попробуйте
        //Нельзя. Потому что у наследника могут содержаться и иные члены класса кроме членов класса родителя
//       Administrator admin2 = (Administrator) user;
//  4. Реализуйте метод, который возвращает родителя, а не наследника. Какой в этом смысл?
       User user1 = admin.getParent();
       // Смысл возможно в том, что этот метод может, например, использоваться как перевод из статуса Admin
       // обратно в статус User, сохраняя при этом только члены класса, присущие родителю
    }
}
