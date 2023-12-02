package theme_5_interface.task_43;

import java.io.*;

public class FileSongLyrics extends SongLyrics{

    public FileSongLyrics() {
    }

    public FileSongLyrics(String song) {
        super(song);
    }

    @Override
    String findTextOfSong(String song) {
        String textOfSong = null;
        try {
            FileReader fileReader = new FileReader("./src/theme_5_interface/task_43/songs.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line1 = bufferedReader.readLine();
            if (line1.equalsIgnoreCase(song + ":")) {
              textOfSong = getTextOfSong(bufferedReader, line1);
            } else {
                String lineCurrent;
                do {
                    lineCurrent = bufferedReader.readLine();
                    if (lineCurrent != null) {
                        if (lineCurrent.equals("*")) {
                            lineCurrent = bufferedReader.readLine();
                            if (lineCurrent.equalsIgnoreCase(song + ":")) {
                                textOfSong = getTextOfSong(bufferedReader, lineCurrent);
                            }
                        }
                    } else {
                        break;
                    }
                } while (!lineCurrent.equalsIgnoreCase(song));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return textOfSong;
    }

    String getTextOfSong(BufferedReader bufferedReader, String songName) throws IOException {
        StringBuilder builder = new StringBuilder();
        builder.append(songName.toUpperCase()).append("\n");
        String line;
        do {
            line = bufferedReader.readLine();
            if (line == null) {
                break;
            } else {
                if (!line.equals("*")) {
                    builder.append(line).append("\n");
                }
            }
        } while (!line.equals("*"));
        return builder.toString();
    }
}
