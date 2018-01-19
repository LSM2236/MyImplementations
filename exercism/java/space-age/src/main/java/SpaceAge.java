class SpaceAge {
    private double seconds;

    SpaceAge(double seconds) {
        this.seconds = seconds;
    }

    double getSeconds() {

        return seconds;
    }

    double onEarth() {
        double sekundyWRokuNaZiemi = 31556926;
        double lataZiemskie = seconds / sekundyWRokuNaZiemi;
        return lataZiemskie;
    }

    double onMercury() {
        double lataMerkury = seconds / (0.2408467  * 31556926);
        return lataMerkury;
    }

    double onVenus() {
        double lataVenus = seconds / (0.61519726 *31556926);
        return lataVenus;
    }

    double onMars() {
        double lataMars = seconds / (1.8808158 *31556926);
        return lataMars;
    }

    double onJupiter() {
        double lataJupiter = seconds / (11.862615 *31556926);
        return lataJupiter;
    }

    double onSaturn() {
        double lataSaturn = seconds / ( 29.447498 *31556926);
        return lataSaturn;
    }

    double onUranus() {
        double lataUranus = seconds / ( 84.016846 *31556926);
        return lataUranus;
    }

    double onNeptune() {
        double lataNeptune = seconds / ( 164.79132 *31556926);
        return lataNeptune;
    }

}
