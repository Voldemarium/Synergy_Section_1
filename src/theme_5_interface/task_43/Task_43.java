package theme_5_interface.task_43;

import java.util.Scanner;

public class Task_43 {
    public static void main(String[] args) {
//  1. Создайте абстрактный класс SongLyrics, который возвращает текст песни по названию.

//  2. Создайте файл в формате: Название песни: текст песни, и так много песен (можете разделять разные песни пустыми
        //  строками, или другим способом) Создайте наследника - FileSongLyrics, который ищет в файле по названию песни,
        //  и если находит, возвращает текст песни
        SongLyrics fileSongLyrics = new FileSongLyrics("Mississippi");
        System.out.println(fileSongLyrics.findTextOfSong(fileSongLyrics.song));

//  3. Создайте наследника - DirectorySongLyrics, который ищет в папке файл с названием песни, и если находит - возвращает
        // текст песни
        SongLyrics directotySongLyrics = new DirectotySongLyrics("./src/theme_5_interface/task_43/songs");
        System.out.println(directotySongLyrics.findTextOfSong("Steel river blues"));

//  4. Создайте ApiSongLyrics, который ищет текст песни в этом апи: https://api.lyrics.ovh/v1/Eminem/Lose%20yourself
     //(откройте в браузере). Артиста и название песни можно менять. Вместо пробелов вставляйте %20.
       //Этот API не работает, поэтому работал с https://lyrsense.com
        SongLyrics apiSongLyrics = new ApiSongLyrics("chris rea", "The blue cafe");
        System.out.println(apiSongLyrics.findTextOfSong(apiSongLyrics.song));

//   5. Создайте метод printLyrics(String artist, String song, SongLyrics songLyrics) - который выводит текст песни.
     //   Вызовите этот метод с наследником по выбору пользователя (из файла, папки или апи)
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to choose an artist? ('y' or 'n')");
        char chooseArtist = scanner.next().charAt(0);
        scanner.nextLine();
        String artist = null;
        if (chooseArtist == 'y') {
            System.out.println("Enter an artist: ");
            artist = scanner.nextLine();
        }
        System.out.println("Enter a song: ");
        String song = scanner.nextLine();
        System.out.println("Enter a place (1 - file, 2 - directory, 3 - APi): ");
        int place = scanner.nextInt();
        SongLyrics songLyrics = null;
        if (place == 1) {
            songLyrics = new FileSongLyrics();
        } else if (place == 2) {
            songLyrics = new DirectotySongLyrics();
        } else if (place == 3) {
            songLyrics = new ApiSongLyrics();
        }

        assert songLyrics != null;
        printLyrics(artist, song, songLyrics);


    }
    static void printLyrics(String artist, String song, SongLyrics songLyrics) {
        songLyrics.artist = artist;
        System.out.println(songLyrics.findTextOfSong(song));
    }
}
