package theme_5_interface.task_42;

public class Task_42 {
    public static void main(String[] args) {
        //  1. Зачем могут пригодиться default-методы в интерфейсах?
        // Default-методы в интерфейсах нужны в случае если во всех классах, использующих этот метод, его реализация
        // является одинаковой.

//  2. Сделайте интерфейс, default-метод которого будет принимать категорию (String category) -
        // который будет запрашивать новости по апи, пример
        // https://inshortsapi.vercel.app/news?category=science(смотреть в браузере)


//  3. Список категорий: allnational //Indian News only
        // business sports world politics technology startup entertainment miscellaneous hatke science automobile.
        // Реализуйте для некоторых категорий этот интерфейс, который вызывает default-метод, и передает туда
        // соответствующую категорию
        NewsOfPolitics newsOfPolitics = new NewsOfPolitics();
        System.out.println(newsOfPolitics.page);
        NewsOfBusiness newsOfBusiness = new NewsOfBusiness();
        System.out.println(newsOfBusiness.page);
        NewsOfAutomobile newsOfAutomobile = new NewsOfAutomobile();
        System.out.println(newsOfAutomobile.page);

    }
}
