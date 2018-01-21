package screens;

import java.io.IOException;
import java.util.Scanner;


public abstract class ScreensAbstract {
    Scanner superscanner = new Scanner(System.in);
    public abstract void display() throws IOException;

    public ScreensAbstract facade() throws IOException {
        return null;
    }
}
