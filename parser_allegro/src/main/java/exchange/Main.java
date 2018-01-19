package exchange;

import screens.MainScreen;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        MainScreen wywolanie = new MainScreen();
        wywolanie.display();
    }
}
