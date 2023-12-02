package theme_5_interface.task_41;

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
                ", mediaType='" + mediaType + '\'' +
                '}';
    }

    public String getPrettyExplanation() {
        return this.explanation.replaceAll("[.!?]", "\n");
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof NasaPictureInfo) {
            NasaPictureInfo info = (NasaPictureInfo) obj;
            return this.fileUrl.equals(info.fileUrl);
        } else {
            return false;
        }
    }
}
