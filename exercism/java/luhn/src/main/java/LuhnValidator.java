class LuhnValidator {
    boolean isValid(String candidate) {
        String[] obrobione = candidate.trim().replaceAll(" ","").split("");
        int suma = 0;
        if (obrobione.length<=1){
            return false;
        }
        for (int i = 0; i < obrobione.length;i++) {
            if (!obrobione[i].matches("\\d+")){
                return false;
            }
        }
        for (int i = obrobione.length -2;i>=0;i-=2){
            obrobione[i] = String.valueOf(Integer.valueOf(obrobione[i]) * 2);
            if (Integer.valueOf(obrobione[i])>9){
                obrobione[i] = String.valueOf(Integer.valueOf(obrobione[i]) - 9);
            }
        }
        for (String s : obrobione){
            suma += Integer.valueOf(s);
        }
        if (suma % 10 == 0){
            return true;
        }
        return false;
    }

}
