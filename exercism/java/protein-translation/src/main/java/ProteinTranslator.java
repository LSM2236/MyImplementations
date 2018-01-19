import java.util.ArrayList;
import java.util.List;

class ProteinTranslator {

    List<String> translate(String rnaSequence) {
        List<String> temp = new ArrayList();
        for (int start = 0; start < rnaSequence.length(); start += 3) {
            temp.add(rnaSequence.substring(start, Math.min(rnaSequence.length(), start + 3)));
        }
        List<String> przetlumaczone = new ArrayList<>();
        for (String s : temp){
            if (s.equals("AUG")){
                przetlumaczone.add("Methionine");
            }
            if (s.equals("UUU") || s.equals("UUC")){
                przetlumaczone.add("Phenylalanine");
            }
            if (s.equals("UUA") || s.equals("UUG")){
                przetlumaczone.add("Leucine");
            }
            if (s.equals("UCU") || s.equals("UCC") || s.equals("UCA") || s.equals("UCG")){
                przetlumaczone.add("Serine");
            }
            if (s.equals("UAU") || s.equals("UAC")){
                przetlumaczone.add("Tyrosine");
            }
            if (s.equals("UGU") || s.equals("UGC")){
                przetlumaczone.add("Cysteine");
            }
            if (s.equals("UGG")){
                przetlumaczone.add("Tryptophan");
            }
            if (s.equals("UAA") || s.equals("UAG") || s.equals("UGA")){
                break;
            }
        }


        return przetlumaczone;
    }
}