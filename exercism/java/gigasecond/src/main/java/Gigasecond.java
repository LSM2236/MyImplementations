import java.math.BigInteger;
import java.time.*;
import java.util.Date;

class Gigasecond {
    private LocalDate birthDate;
    private LocalDateTime birthDateTime;

    Gigasecond(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    Gigasecond(LocalDateTime birthDateTime) {
        this.birthDateTime = birthDateTime;
    }

    LocalDateTime getDate() {
        if (birthDateTime == null) {
            birthDateTime = LocalDateTime.of(birthDate, LocalTime.MIDNIGHT);
        }
        LocalDateTime data = birthDateTime.plusSeconds(1000000000);
        return data;
    }

}
