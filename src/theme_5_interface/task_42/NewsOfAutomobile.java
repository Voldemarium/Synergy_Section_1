package theme_5_interface.task_42;

public class NewsOfAutomobile implements NewsByCategory {
    String page;


    NewsOfAutomobile() {
        this.page = getNewsByCategory("automobile");
    }

}