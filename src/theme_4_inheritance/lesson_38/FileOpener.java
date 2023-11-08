package theme_4_inheritance.lesson_38;

import javax.imageio.IIOException;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class FileOpener {
    File file;

    public FileOpener(File file) {
        this.file = file;
    }

    public void openFile() {
        Desktop desktop = Desktop.getDesktop();
        try {
            desktop.open(this.file);
        } catch (IOException e) {
            throw new RuntimeException("Error when opening file, ", e);
        }
    }

    public void printFileInfo() {
        System.out.println("This is file " + file.getName());
        System.out.println("It stored on path " + file.getPath());

    }
}
