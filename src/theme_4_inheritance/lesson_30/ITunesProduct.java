package theme_4_inheritance.lesson_30;

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
