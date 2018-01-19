package exchange;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
        ParsowanieMaila parserTextu = new ParsowanieMaila();
        StringBuilder sparsowanyText = new StringBuilder();
        List wczytanyText = new ArrayList(parserTextu.tlumaczenie());
        test(wczytanyText,sparsowanyText);
    }
    public static void test(List<String> lista, StringBuilder parse){
        for (String s : lista){
            if (Pattern.compile("^[\\p{L} .'-]+$").matcher(s).find()){
                parse.append(s);
            }
        }
        System.out.println(parse);

    }
}
