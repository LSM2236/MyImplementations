import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class HandshakeCalculator {

    List<Signal> calculateHandshake(int number) {
        List<Signal> zwroconeSygnaly = new ArrayList<>();
        int liczbaBin = Integer.parseInt(Integer.toBinaryString(number));
        int wartoscPoczatkowa = liczbaBin;
        if (liczbaBin > 10000){
            liczbaBin-=10000;
        }
        if (liczbaBin == 10000){
            liczbaBin = 0;
        }
        while (liczbaBin!= 0){
            if (liczbaBin >= 1000){
                zwroconeSygnaly.add(Signal.JUMP);
                liczbaBin-=1000;
            }
            if (liczbaBin >= 100 && liczbaBin <= 999){
                zwroconeSygnaly.add(Signal.CLOSE_YOUR_EYES);
                liczbaBin-=100;
            }
            if (liczbaBin >= 10 && liczbaBin<= 99){
                zwroconeSygnaly.add(Signal.DOUBLE_BLINK);
                liczbaBin-=10;
            }
            if (liczbaBin >= 1 && liczbaBin<=9){
                zwroconeSygnaly.add(Signal.WINK);
                liczbaBin-=1;
            }
        }
        Collections.reverse(zwroconeSygnaly);
        if (wartoscPoczatkowa>10000){
            Collections.reverse(zwroconeSygnaly);
        }
        return zwroconeSygnaly;
    }

}
