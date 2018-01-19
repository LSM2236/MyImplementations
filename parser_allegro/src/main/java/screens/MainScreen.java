package screens;

import java.io.IOException;
import java.util.IllegalFormatException;
import java.util.Scanner;

public class MainScreen extends ScreensAbstract {

    @Override
    public ScreensAbstract display() throws IOException {
        System.out.println("Wybierz jedną z opcji \n" +
                "1. Wczytaj text do pliku \n" +
                "2. Zdefiniuj sciezke dla wprowadzonych danych\n" +
                "3. Wyjdz z programu");
        Scanner sc = new Scanner(System.in);
        try  {
            String wyborOpcji = sc.nextLine();
            Integer opcje = Integer.parseInt(wyborOpcji);
            switch (opcje) {
                case 1:
                    return new ParserScreen().display();
            }
        }catch (IllegalFormatException e){
            System.out.println("Wprowadzono niepoprawna opcje");
        }finally {
            sc.close();
        }
        return null;
    }
}
