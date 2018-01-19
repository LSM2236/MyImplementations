
class ReverseString {

    String reverse(String wyrazenie) {
        StringBuilder wspak = new StringBuilder(wyrazenie);
        wspak.reverse();
        return String.valueOf(wspak);
    }
  
}