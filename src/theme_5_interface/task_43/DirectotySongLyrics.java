package theme_5_interface.task_43;

import java.io.*;

public class DirectotySongLyrics extends SongLyrics {
    String directoryPath = "./src/theme_5_interface/task_43/songs";

    public DirectotySongLyrics() {
    }

    public DirectotySongLyrics(String directoryPath) {
//        super(song);
        this.directoryPath = directoryPath;
    }

    @Override
    String findTextOfSong(String song) {
        File[] files = getFilesOfDirectory();
        String textOfSong = null;
        for (File file : files) {
            String fileName = file.getName().substring(0, file.getName().indexOf("."));
            if (fileName.equalsIgnoreCase(song)) {
                try {
                    FileReader fileReader = new FileReader(file.getPath());
                    BufferedReader bufferedReader = new BufferedReader(fileReader);
                    textOfSong = getTextOfSong(bufferedReader, song);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return textOfSong;
    }

    String getTextOfSong(BufferedReader bufferedReader, String songName) throws IOException {
        StringBuilder builder = new StringBuilder();
        String line;
        do {
            line = bufferedReader.readLine();
            if (line != null) {
                builder.append(line).append("\n");
            }
        } while (line != null);
        return builder.toString();
    }

    File[] getFilesOfDirectory() {
        File directory = new File(this.directoryPath);
        return directory.listFiles();
    }
}
