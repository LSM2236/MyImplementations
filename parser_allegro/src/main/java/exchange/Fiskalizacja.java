package exchange;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Fiskalizacja {
    public static void main(String[] args) throws IOException {
        ParsowanieMaila parsowanieMaila = new ParsowanieMaila();
        ParsowanieMaila parserTextu = new ParsowanieMaila();
        StringBuilder sparsowanyText = new StringBuilder();

        List wczytanyText = new ArrayList(parserTextu.tlumaczenie());
        parsowanieMaila.dodanieDaty(wczytanyText, sparsowanyText);
        parsowanieMaila.dodanieNUzytkownika(wczytanyText, sparsowanyText);
        parsowanieMaila.dodanieImienia(wczytanyText, sparsowanyText);
        parsowanieMaila.dodanieZakupu(wczytanyText, sparsowanyText);
        parsowanieMaila.dodanieSposobuDostawy(wczytanyText, sparsowanyText);
        parsowanieMaila.dodanieStatusuPlatnosciIZamowienia(wczytanyText, sparsowanyText);
        //Fiskalizacja.obliczaniePodatkuOdTransakcji(sparsowanyText);
    }
    public StringBuilder obliczaniePodatkuOdTransakcji(StringBuilder sparsowanyText){
        double wartosc = 0;
        Pattern pattern2 = Pattern.compile("([0-9]{1,3}x+)*[0-9]{1,3}g+");
        Pattern pattern3 = Pattern.compile("\\s+x+[0-9]{1,3}");
        List<Double> pojZak = new ArrayList<>();
        for (String s : sparsowanyText.toString().split("\\|")) {
            Matcher matcherNaZakup = pattern2.matcher(s);
            Matcher matcherNaIlosc = pattern3.matcher(s);
            double count = 0;
            double value = 0;
            while (matcherNaIlosc.find()) {
                count = Integer.parseInt(String.valueOf(matcherNaIlosc.group()).replaceAll("[^0-9]", "").trim());
            }
            while (matcherNaZakup.find()) {
                if (matcherNaZakup.group().equals("10x250g")) {
                    value = 13;
                }
                if (matcherNaZakup.group().equals("10x500g")) {
                    value = 23.50;
                }
                if (matcherNaZakup.group().equals("250g")) {
                    value = 1.3;
                }
                if (count == 0) {
                    count = 1;
                }
                if (value != 0) {
                    pojZak.add(value * count);
                }
            }
        }
        for (Double d : pojZak){
            wartosc += d;
        }
        Double podatek = wartosc * 0.035;
        DecimalFormat numberFormat = new DecimalFormat("##.##");
        sparsowanyText.append("Wartosc : "+wartosc + "|" + "Podatek : "+numberFormat.format(podatek));
        return  sparsowanyText;
    }
    public void obliczaniePodatkuMiesiecznego(String sciezkaDoPliku, Integer miesiac){
        if (miesiac < 10){
            miesiac = Integer.valueOf("0"+ String.valueOf(miesiac));
        }
        try {
            for (String wiersz : Files.readAllLines(Paths.get(sciezkaDoPliku))){
                if (wiersz.contains(String.valueOf(miesiac))){

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
