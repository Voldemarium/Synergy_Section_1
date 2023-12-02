package theme_5_interface.task_42;

public class NewsOfBusiness implements NewsByCategory {
    String page;


    NewsOfBusiness() {
        this.page = getNewsByCategory("business");
    }

}