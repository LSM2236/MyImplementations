import java.time.Instant;

import static java.lang.Character.isLetter;

class Acronym {
    String phrase;

    Acronym(String phrase) {
        this.phrase = phrase;
    }

    String get() {
        StringBuilder obrobiony = new StringBuilder();
        for (int i = 0; i < phrase.length(); i++) {
            if (i == 0) {
                obrobiony.append(phrase.charAt(i));
            } else if (phrase.charAt(i) ==  ' ' || phrase.charAt(i) ==  '-' && isLetter(phrase.charAt(i+1))) {
                    obrobiony.append(phrase.charAt(i+1));
            }
        }
        return obrobiony.toString().toUpperCase();
    }
}

