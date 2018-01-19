import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PangramChecker {

    public boolean isPangram(String input) {
        input = input.toLowerCase().trim().replaceAll("[^A-Za-z]","");
        List<Character> doPorownania = new ArrayList<>();
        String alfabet = "abcdefghijklmnoprstuwxyz";
        for (int a = 0; a<alfabet.length(); a++){
            doPorownania.add(alfabet.charAt(a));
        }
        boolean jestPangramem = false;
        List<Character> listaZnakowInputa = new ArrayList<>();
        for (int i=0; i<input.length();i++) {

            if (!listaZnakowInputa.contains(input.charAt(i))) {
                listaZnakowInputa.add(input.charAt(i));
            }
        }
        Collections.sort(listaZnakowInputa);
        if (listaZnakowInputa.containsAll(doPorownania)){
            jestPangramem = true;
        }


    return jestPangramem;
    }

}
