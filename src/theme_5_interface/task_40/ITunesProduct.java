package theme_5_interface.task_40;

public class ITunesProduct {
    String artistName;
    String collectionName;
    String previewUrl;
    String country;

    void printIntroducePreview() {
        System.out.println(this.artistName + "-" + this.collectionName);
        System.out.println("url to preview: " + this.previewUrl);
    }


}
