import java.util.ArrayList;
import java.util.List;

class SumOfMultiples {
    private int[] set;
    private int number;

    SumOfMultiples(int number, int[] set) {
        this.set = set;
        this.number = number;
    }

    int getSum() {
        Integer sum = 0;
        List<Integer> wyniki = new ArrayList<>();
        for (int i=0;i<set.length;i++){
            int mnoznik = 1;
            int wynik = 0;
            while(wynik<number){
                wynik = set[i]*mnoznik;
                mnoznik++;
                if (wynik<number && !wyniki.contains(wynik)) {
                    wyniki.add(wynik);
                }
            }
        }
        for (int i =0;i<wyniki.size();i++){
            sum += wyniki.get(i);
        }
        return sum;
    }
}
