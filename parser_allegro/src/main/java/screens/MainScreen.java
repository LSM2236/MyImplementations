package screens;

import java.io.IOException;
import java.util.IllegalFormatException;
import java.util.Scanner;

public class MainScreen extends ScreensAbstract {

    @Override
    public void display() throws IOException {
        MainScreen mainScreen = new MainScreen();
        ParserScreen parserScreen = new ParserScreen();
        System.out.println("Wybierz jedną z opcji \n" +
                "1. Wczytaj text do pliku \n" +
                "2. Zdefiniuj sciezke dla wprowadzonych danych\n" +
                "3. Wyjdz z programu");
        try  {
            String wyborOpcji = superscanner.nextLine();
            Integer opcje = Integer.parseInt(wyborOpcji);

            switch (opcje) {
                case 1:
                    parserScreen.facade();
                case 2:
                    return;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("wybrano opcje spoza zakresu");
                    mainScreen.display();
            }
        }catch (IllegalFormatException e){
            System.out.println("Wprowadzono niepoprawna opcje. Uzyj cyfr");
        }finally {
            superscanner.close();
        }
        return;
    }
}
