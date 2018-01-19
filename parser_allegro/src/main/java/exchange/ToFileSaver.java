package exchange;

import java.io.FileWriter;
import java.io.IOException;

public class ToFileSaver {
    public void zapisDoPliku(String path, StringBuilder wiersz) throws IOException {
        FileWriter fw = new FileWriter(path, true);
        fw.write(String.valueOf(wiersz));
        fw.flush();
        fw.close();
    }
}