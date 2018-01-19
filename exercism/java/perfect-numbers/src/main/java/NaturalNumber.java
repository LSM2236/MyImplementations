class NaturalNumber {
    int number;

    public NaturalNumber(int number) {
        this.number = number;
        if (number<1){
            throw new IllegalArgumentException("You must supply a natural number (positive integer)");
        }
    }

    public Classification getClassification() {
        Classification klasa = null;
        int wartosc = 0;
        for (int i = 0; i < number; i++) {

            if (i==1 || i > 1 && number % i == 0) {
                wartosc += i;
            }
        }
        if (wartosc == number) {
            klasa = Classification.PERFECT;
        }
        if (wartosc < number) {
            klasa = Classification.DEFICIENT;
        }
        if (wartosc > number) {
            klasa = Classification.ABUNDANT;
        }
        return klasa;
    }
}
