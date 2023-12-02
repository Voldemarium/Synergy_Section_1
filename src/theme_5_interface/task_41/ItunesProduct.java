package theme_5_interface.task_41;

import utils.DownloadPage;

import java.io.IOException;

public class ItunesProduct {
    String artistName;
    String trackName;
    String previewUrl;
    String country;

    public ItunesProduct(String artistName, String trackName, String previewUrl, String country) {
        this.artistName = artistName;
        this.trackName = trackName;
        this.previewUrl = previewUrl;
        this.country = country;
    }

    public static ItunesProduct findItunesProduct(String searchRequest, int limit, String mediaType) {
        ItunesPreviewPlayer player = new ItunesPreviewPlayer();
        String url = player.buildUrl(searchRequest, limit, mediaType);
        DownloadPage downloadPage = new DownloadPage();
        String page = "";
        try {
            page = downloadPage.downloadWebPage(url);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String artistName = player.getTagString(page, "artistName");
        String trackNameName = player.getTagString(page, "trackName");
        String previewUrl = player.getTagString(page, "previewUrl");
        String country = player.getTagString(page, "country");
        return new ItunesProduct(artistName, trackNameName, previewUrl, country);
    }

    void printIntroducePreview() {
        System.out.println(this.artistName + "-" + this.trackName);
        System.out.println("url to preview: " + this.previewUrl);
    }

    @Override
    public String toString() {
        return "ItunesProduct{" +
                "artistName='" + artistName + '\'' +
                ", trackName='" + trackName + '\'' +
                ", previewUrl='" + previewUrl + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ItunesProduct) {
            ItunesProduct product = (ItunesProduct) obj;
            return this.artistName.equals(product.artistName) &&
                    this.trackName.equals(product.trackName) &&
                    this.previewUrl.equals(product.previewUrl) &&
                    this.country.equals(product.country);
        } else {
            return false;
        }
    }
}
