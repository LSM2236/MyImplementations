public class Hamming {
    String leftStrand;
    String rightStrand;

    Hamming(String leftStrand, String rightStrand) {
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
        String substring = "leftStrand and rightStrand must be of equal length.";
        if (leftStrand.length()!=rightStrand.length()){
            throw new IllegalArgumentException(substring);
        }

    }

    int getHammingDistance() {

        int iloscRoznic = 0;
        if (leftStrand.length() == rightStrand.length()) {
            for (int i = 0; i < leftStrand.length(); i++) {
                if (!(leftStrand.charAt(i) == rightStrand.charAt(i))) {
                    iloscRoznic++;
                }
            }
        }
        return iloscRoznic;
    }

}
