import java.util.ArrayList;
import java.util.List;

class IsbnVerifier {
    boolean isValid(String stringToVerify) {
        String[] separate = stringToVerify.replaceAll("[^0-9]","").trim().split("");
        List<Integer> temp = new ArrayList<>();
        for (String s : separate) {
            temp.add(Integer.valueOf(s));
        }
        for (char c : stringToVerify.toCharArray()) {
            if (c == 'X') {
                temp.add(10);
            }
        }
        long wynik = 0;
        Integer potega = 10;

        for (int i = 0; i < temp.size(); i++) {
            wynik += temp.get(i)*potega ;
            potega--;
        }
        if (wynik % 11 == 0 && temp.size() <=10) {
            return true;
        }
        return false;
    }

}
