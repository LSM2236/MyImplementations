package screens;

import exchange.ParsowanieMaila;
import exchange.ToFileSaver;

import java.io.IOException;
import java.util.*;

public class ParserScreen extends ScreensAbstract{


    @Override
    public ScreensAbstract display() throws IOException {
        System.out.println("Wklej treść wiadomosci");
        String path = "C:\\Users\\dom\\Desktop\\PlikTestowy.ods";
        ParsowanieMaila parserTextu = new ParsowanieMaila();
        StringBuilder sparsowanyText = new StringBuilder();

        List wczytanyText = new ArrayList(parserTextu.tlumaczenie());

        parserTextu.dodanieDaty(wczytanyText, sparsowanyText);
        parserTextu.dodanieNUzytkownika(wczytanyText, sparsowanyText);
        parserTextu.dodanieImienia(wczytanyText,sparsowanyText);
        parserTextu.dodanieZakupu(wczytanyText, sparsowanyText);
        parserTextu.dodanieSposobuDostawy(wczytanyText,sparsowanyText);
        parserTextu.dodanieStatusuPlatnosciIZamowienia(wczytanyText, sparsowanyText);
        ToFileSaver zapisDoPliku = new ToFileSaver();
        zapisDoPliku.zapisDoPliku(path, sparsowanyText);

        System.out.println(sparsowanyText);

        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Wybierz jedną z opcji \n" +
                    "1. Wczytaj kolejny plik \n" +
                    "2. Powrot do menu glownego \n" +
                    "3. Wyjdz z programu\n");
            String wyborOpcji = scanner.nextLine();
            Integer opcje = Integer.parseInt(wyborOpcji);

            switch (opcje) {
                case 1:
                    return this.display();
                case 2:
                    return new MainScreen().display();
                case 3:
                    System.exit(0);
            }

        } catch (NumberFormatException e) {
            System.out.println("Wprowadzono niepoprawna opcje");
            return this.display();
        }finally {
            scanner.close();
        }
        return null;
    }
}
