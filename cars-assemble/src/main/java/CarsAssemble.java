public class CarsAssemble {

    public double productionRatePerHour(int speed) {
        int baseProduction = speed * 221;

        if (speed <= 4){
            return baseProduction;
        } else if (speed <= 8) {
            return baseProduction * 0.9;
        } else if (speed == 9) {
            return baseProduction * 0.8;
        } else {
            return baseProduction * 0.77;
        }
    }

    public int workingItemsPerMinute(int speed) {
        return (int) (productionRatePerHour(speed) / 60);
    }
}
