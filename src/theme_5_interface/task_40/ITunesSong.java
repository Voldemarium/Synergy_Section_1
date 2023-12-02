package theme_5_interface.task_40;

import utils.DownloadPage;

import java.io.IOException;

public class ITunesSong extends ITunesProduct {
    String artistName;
    String trackName;
    String trackCensoredName;
    double trackPrice;
    double collectionPrice;
    boolean json;

    public ITunesSong(String searchRequest, int limit, boolean json) {
        String url = ItunesPreviewPlayer.buildUrl(searchRequest, limit, "music");
        DownloadPage downloadPage = new DownloadPage();
        String page = "";
        try {
            page = downloadPage.downloadWebPage(url);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        this.artistName = ItunesPreviewPlayer.getTagString(page, "artistName");
        this.trackName = ItunesPreviewPlayer.getTagString(page, "trackName");
        this.trackCensoredName = ItunesPreviewPlayer.getTagString(page, "trackCensoredName");
        this.trackPrice = Double.parseDouble(ItunesPreviewPlayer.getTagNumbers(page, "trackPrice"));
        this.collectionPrice = Double.parseDouble(ItunesPreviewPlayer.getTagNumbers(page, "collectionPrice"));
        this.json = json;
    }

    @Override
    public String toString() {
        if (json) {
            return "\"artistName\":\"" + artistName + "\"," + "\n" +
                    "\"trackName\":\"" + trackName +"\"," + "\n" +
                    "\"trackCensoredName\":\"" + trackCensoredName +"\"," +"\n" +
                    "\"trackPrice\":" + trackPrice + "," + "\n" +
                    "\"collectionPrice\":" + collectionPrice;
        } else {
            return "<artistName>" + artistName + "</artistName>" + "\n" +
                    "<trackName>" + trackName + "</trackName>" + "\n" +
                    "<trackCensoredName>" + trackCensoredName + "</trackCensoredName>" + "\n" +
                    "<trackPrice>" + trackPrice + "</trackPrice>" + "\n" +
                    "<collectionPrice>" + collectionPrice + "</collectionPrice>";
        }
    }
}
