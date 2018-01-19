import java.util.ArrayList;
import java.util.List;

class ArmstrongNumbers {

	boolean isArmstrongNumber(int numberToCheck) {
		String numer = String.valueOf(numberToCheck);
        List<Integer> power = new ArrayList<>();
        Integer suma = 0;
        for (int i =0; i<numer.length();i++){
            power.add((int) Math.pow(Integer.valueOf(numer.substring(i, i + 1)), numer.length()));
        }
        for (int j=0;j<power.size();j++){
            suma += power.get(j);
        }
        if (suma == numberToCheck){
            return true;
        }
        return false;
	}

}
