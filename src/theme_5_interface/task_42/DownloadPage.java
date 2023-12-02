package theme_5_interface.task_42;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class DownloadPage {
    public String downloadWebPage(String url) throws IOException {
        StringBuilder result = new StringBuilder();
        String line;
        try (InputStream inputStream = new URL(url).openConnection().getInputStream()) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while ((line = bufferedReader.readLine()) != null) {
                result.append(line);
            }
        }
        return result.toString();
    }
}
