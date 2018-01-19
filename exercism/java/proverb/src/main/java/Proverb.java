
class Proverb {
    String[] words;

    Proverb(String[] words) {
        this.words=words;
    }

    String recite() {
        StringBuilder recytacja = new StringBuilder();
        String ostatniWiersz = "And all for the want of a nail.";

        for (int s = 0;s< words.length-1; s++) {
            recytacja.append(String.format("For want of a %s the %s was lost.\n", words[s],words[s+1]));
        }

        if (words.length != 0) {
            if (words[words.length-1]=="battle"){
                ostatniWiersz = "And all for the want of a pin.";
            }
            recytacja.append(ostatniWiersz);
        }
        return recytacja.toString();
    }
}
