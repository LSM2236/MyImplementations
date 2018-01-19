import java.util.*;

import static java.util.Objects.requireNonNull;

class Scrabble {
    private String word;

    Scrabble(String word) {
        this.word = word;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Scrabble scrabble = (Scrabble) o;

        return word.equals(scrabble.word);
    }

    @Override
    public int hashCode() {
        return word.hashCode();
    }

    int getScore() {
        String LiteryZaJeden = "AEIOULNRST";
        String LiteryZaDwa = "DG";
        String LiteryZaTrzy = "BCMP";
        String LiteryZaCztery = "FHVWY";
        String LiteryZaPiec = "K";
        String LiteryZaOsiem = "JX";
        String LiteryZaDziesiec = "QZ";
        int score = 0;
        for (char c : word.toUpperCase().toCharArray()) {
            if (LiteryZaJeden.contains(String.valueOf(c))) {
                score+=1;
            }if (LiteryZaDwa.contains(String.valueOf(c))){
                score+=2;
            }if (LiteryZaTrzy.contains(String.valueOf(c))){
                score+=3;
            }if (LiteryZaCztery.contains(String.valueOf(c))){
                score+=4;
            }if (LiteryZaPiec.contains(String.valueOf(c))){
                score+=5;
            }if (LiteryZaOsiem.contains(String.valueOf(c))){
                score+=8;
            }if (LiteryZaDziesiec.contains(String.valueOf(c))){
                score+=10;
            }else {
                continue;
            }
        }
        return score;
    }

}
