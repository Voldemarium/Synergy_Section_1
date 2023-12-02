package theme_5_interface.task_43;

public abstract class SongLyrics {
    String artist;
    String song;
    String textOfSong;

    public SongLyrics() {
    }

    public SongLyrics(String song) {
        this.song = song;
    }

    public SongLyrics(String artist, String song) {
        this.artist = artist;
        this.song = song;
    }

    abstract String findTextOfSong(String song);

}
