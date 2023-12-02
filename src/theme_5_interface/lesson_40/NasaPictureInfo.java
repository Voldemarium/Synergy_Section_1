package theme_5_interface.lesson_40;

public class NasaPictureInfo {
    String title;
    String date;
    String explanation;
    String fileUrl;
    String mediaType;

    public NasaPictureInfo(String title, String date, String explanation, String fileUrl,  String mediaType) {
        this.title = title;
        this.date = date;
        this.explanation = explanation;
        this.fileUrl = fileUrl;
        this.mediaType = mediaType;
    }

    @Override
    public String toString() {
        return "title='" + title + '\'' +
                ", date='" + date + '\'' +
//                 ", explanation='" + explanation + '\'' +
//                ", fileUrl='" + fileUrl + '\'' +
                ", mediaType='" + mediaType + '\'' +
                '}';
    }

    public String getPrettyExplanation() {
        return this.explanation.replaceAll("[.!?]", "\n");
    }
}
