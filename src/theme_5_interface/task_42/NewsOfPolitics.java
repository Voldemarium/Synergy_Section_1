package theme_5_interface.task_42;

public class NewsOfPolitics implements NewsByCategory {
    String page;
    
    NewsOfPolitics() {
        this.page = getNewsByCategory("politics");
    }
    
}