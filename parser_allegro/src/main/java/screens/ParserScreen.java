package screens;

import exchange.Fiskalizacja;
import exchange.ParsowanieMaila;
import exchange.ToFileSaver;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class ParserScreen extends ScreensAbstract{

    @Override
    public void display() throws IOException {
        ParserScreen parserScreen = new ParserScreen();
        MainScreen mainScreen = new MainScreen();
            try {
                System.out.print("Wybierz jedną z opcji \n" +
                        "1. Wczytaj kolejny plik \n" +
                        "2. Powrot do menu glownego \n" +
                        "3. Wyjdz z programu\n");
                String wyborOpcji = superscanner.nextLine();
                Integer opcje = Integer.parseInt(wyborOpcji);

                switch (opcje) {
                    case 1:
                        parserScreen.facade();
                    case 2:
                        mainScreen.display();
                    case 3:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("wybrano opcje spoza zakresu");
                        parserScreen.facade();
                }

            } catch (NumberFormatException e) {
                System.out.println("Wprowadzono niepoprawna opcje");
                parserScreen.display();
            } finally {
                superscanner.close();
            }

        return;
    }
    public ScreensAbstract facade() throws IOException {

        System.out.println("Wklej treść wiadomosci. Jesli się rozmyslileś/aś wpisz \"exit\" \n" +
                "i potwierdz przyciskiem Enter");
        String path = "C:\\Users\\dom\\Desktop\\PlikTestowy.ods";
        ParsowanieMaila parserTextu = new ParsowanieMaila();
        StringBuilder sparsowanyText = new StringBuilder();
        Fiskalizacja obliczaniePodatkuIWartosci = new Fiskalizacja();

        List wczytanyText = new ArrayList(parserTextu.tlumaczenie());

        parserTextu.dodanieDaty(wczytanyText, sparsowanyText);
        parserTextu.dodanieNUzytkownika(wczytanyText, sparsowanyText);
        parserTextu.dodanieImienia(wczytanyText, sparsowanyText);
        parserTextu.dodanieZakupu(wczytanyText, sparsowanyText);
        parserTextu.dodanieSposobuDostawy(wczytanyText, sparsowanyText);
        parserTextu.dodanieStatusuPlatnosciIZamowienia(wczytanyText, sparsowanyText);
        obliczaniePodatkuIWartosci.obliczaniePodatkuOdTransakcji(sparsowanyText);
        ToFileSaver zapisDoPliku = new ToFileSaver();
        ParserScreen ps = new ParserScreen();
        try {
            zapisDoPliku.zapisDoPliku(path, sparsowanyText);

            System.out.println(sparsowanyText);
            ps.display();
        }catch (FileNotFoundException e){
            System.out.println("Błąd zapisu. Sprawdz czy plik docelowy nie jest uzywany przez inny program\n" +
                    "wcisnij enter aby kontynuowac");
            String kontynuuj = superscanner.nextLine();
            ps.display();
        }
        return null;
    }

}
