public class Robot {
    private int batteryLevel, maxLevel, chargingRate;

    public Robot(int batteryLevel, int maxLevel, int chargingRate) {
        this.batteryLevel = batteryLevel;
        this.maxLevel = maxLevel;
        this.chargingRate = chargingRate;
    }

    public int getMaxLevel() {
        return maxLevel;
    }

    public boolean performTask(int requiredEnergy) {
        boolean isEnergyEnough = requiredEnergy < batteryLevel;
        if (isEnergyEnough) {
            batteryLevel -= requiredEnergy;
        }
        return isEnergyEnough;
    }

    public int timeToCharge() {
        int timeToCharge = (maxLevel - batteryLevel) / chargingRate;
        return timeToCharge;
    }

    public void charge() {
        batteryLevel = maxLevel;
    }

}