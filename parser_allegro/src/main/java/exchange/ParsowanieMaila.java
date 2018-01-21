package exchange;

import screens.MainScreen;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParsowanieMaila {
    List<String> text = new ArrayList<>();

    public List<String> tlumaczenie() {
        Scanner scanner = new Scanner(System.in);
        MainScreen mainScreen = new MainScreen();
        try {
            while (scanner.hasNext()) {
                String wiersz = scanner.nextLine().trim();
                if (!wiersz.isEmpty()) {
                    text.add(wiersz);
                }
                if (wiersz.contains("Zespół Allegro")) {
                    break;
                }
                if(wiersz.contains("exit")){
                    mainScreen.display();
                }
            }
        } catch (IOException e) {
            System.out.println("Koniec pliku");
        } finally {
            //System.out.println(text);

        }
        return text;
    }
    public StringBuilder dodanieZakupu (List<String> text, StringBuilder sparsowaneDane) {
        Pattern pattern = Pattern.compile("\\sx[0-9]+");
        for (String s : text) {
            Matcher m = pattern.matcher(s);

            if (s.contains("POCHŁANIACZY WILGOCI ZESTAW 10 X 500 G")) {
                sparsowaneDane.append("10x500g ");
                while (m.find()){
                    sparsowaneDane.append(m.group());
                }
                sparsowaneDane.append("|");

            }
            if (s.contains("POCHŁANIACZY WILGOCI 250G UNIWERSALNE")){
                sparsowaneDane.append("250g");
                while (m.find()){
                    sparsowaneDane.append(m.group());
                }
                sparsowaneDane.append("|");
            }
            if (s.contains("WILGOCI ZESTAW 10 X 250 G")){
                sparsowaneDane.append("10x250g");
                while (m.find()){
                    sparsowaneDane.append(m.group());
                }
                sparsowaneDane.append("|");
            }
        }
        return sparsowaneDane;
    }


    public StringBuilder dodanieNUzytkownika(List<String> text, StringBuilder sparsowaneDane) {
        for (String s : text) {
            if (s.contains("Allegro Finanse - Kupujący")) {
                String zbedneSlowa = "Allegro Finanse Kupujący wybrał - sposób zapłaty dostawy w ofercie";
                String[] calyString = s.replaceAll("\\(.*\\)","").split(" ");
                for (int i = 0; i < calyString.length; i++) {
                        if(!zbedneSlowa.contains(calyString[i])){
                            sparsowaneDane.append(calyString[i]+"|");
                        }
                    }
                }
            }
        return sparsowaneDane;
    }

    public StringBuilder dodanieDaty(List<String> text, StringBuilder sparsowaneDane) {
        String miesiace = "styczeń stycznia luty lutego marzec marca kwiecień kwietnia maj maja czerwiec " +
                "czerwca lipiec lipca sierpień sierpnia wrzesień września październik października listopad " +
                "listopada grudzień grudnia";
        for (String s : text) {
            String temp = s.replaceAll("[^A-Za-zńćśąę]","");
            if (miesiace.contains(s.replaceAll("[^A-Za-zńćśąę]",""))&& temp.length()>=3) {
                sparsowaneDane.append(s+"|");

            }
        }
        return sparsowaneDane;
    }
    public StringBuilder dodanieImienia (List<String> text, StringBuilder sparsowaneDane) {
        for (String s : text){
            if(s.contains("Adres do wysyłki") || s.contains("Adres Kupującego")){
                if (Pattern.compile("[a-zA-Z\\s]+").matcher(s).find()) {
                    sparsowaneDane.append(text.get(text.indexOf(s) + 1)+"|");
                }else {
                    sparsowaneDane.append(text.get(text.indexOf(s) + 2)+"|");
                }
            }
        }
        return sparsowaneDane;
    }
    public StringBuilder dodanieSposobuDostawy(List<String> text, StringBuilder sparsowaneDane){
        for (String s : text){
            if(s.contains("Sposób i koszt dostawy")){
                String temp = text.get(text.indexOf(s)+1).trim().replaceAll("[A-Za-złęąćźżń]", "")
                        .replaceAll(",",".");
                if (Double.valueOf(temp)==0){
                    sparsowaneDane.append("Darmowa wysylka");
                }
                if (Double.valueOf(temp)%8.60 == 0) {
                    sparsowaneDane.append("Paczkomat|");
                }
                if (Double.valueOf(temp)%7.20 == 0){
                    sparsowaneDane.append("Minipaczka|");
                }
                if (Double.valueOf(temp)%12.10 == 0){
                    sparsowaneDane.append("Paczkomat pobranie|");
                }
                if (Double.valueOf(temp) %4.75 == 0){
                    sparsowaneDane.append("List ekonomiczny|");
                }
                if (Double.valueOf(temp)== 13.50 || (Double.valueOf(temp)>13.50 && (Double.valueOf(temp)-13.50) % 0.80 == 0)
                        ||(Double.valueOf(temp)>13.50 && (Double.valueOf(temp)-13.50) % 1.50 == 0)){
                    sparsowaneDane.append("Kurier|");
                }

                if (Double.valueOf(temp)== 17 || (Double.valueOf(temp)>17 && Double.valueOf(temp)-17 % 0.80 == 0)
                        ||(Double.valueOf(temp)>17 && (Double.valueOf(temp)-17) % 1.50 == 0)){
                    sparsowaneDane.append("Kurier pobranie|");
                }
            }
        }
        return sparsowaneDane;
    }
    public StringBuilder dodanieStatusuPlatnosciIZamowienia(List<String> text, StringBuilder sparsowaneDane){
        for (String s : text){
            if(s.contains("Metoda płatności")){
                if(s.contains("Płacę przelewem tradycyjnym")){
                    sparsowaneDane.append("Zwykły przelew");
                }
                if(s.contains("Płacę przy odbiorze")){
                    sparsowaneDane.append("Pobranie");
                }else {
                    continue;
                }
            }
        }
        return sparsowaneDane;
    }
}

