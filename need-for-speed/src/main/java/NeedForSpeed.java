class NeedForSpeed {
    private final int speed;
    private final int batteryDrain;
    private int battery;
    private int distance;

    NeedForSpeed(int speed, int batteryDrain) {
        this.speed = speed;
        this.batteryDrain = batteryDrain;
        this.battery = 100;
        this.distance = 0;
    }

    public boolean batteryDrained() {
        // Logika disederhanakan agar lebih mudah dibaca
        return battery < batteryDrain;
    }

    public int distanceDriven() {
        return distance;
    }

    public void drive() {
        if (!batteryDrained()){
            distance += speed;
            battery -= batteryDrain;
        }
    }

    public static NeedForSpeed nitro() {
        return new NeedForSpeed(50, 4);
    }

    // Method baru untuk menghitung kapasitas tempuh maksimal mobil
    public int maxDistance() {
        int maximumDrives = 100 / batteryDrain;
        return maximumDrives * speed;
    }
}

class RaceTrack {
    private final int distance;

    RaceTrack(int distance) {
        this.distance = distance;
    }

    public boolean canFinishRace(NeedForSpeed car) {
        // Kini hanya membandingkan kalkulasi tanpa mengubah state baterai mobil
        return car.maxDistance() >= distance;
    }
}