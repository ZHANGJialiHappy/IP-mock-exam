public class Car {
    private String plate;
    private int mileage, lastServiceMileage, tankCapacity, gasLevel;
    private float consumption;

    public Car(String plate, int tankCapacity, float consumption) {
        this.plate = plate;
        this.tankCapacity = tankCapacity;
        this.consumption = consumption;
        mileage = 0;
        lastServiceMileage = 0;
        gasLevel = 0;
    }

    public String getPlate() {
        return plate;
    }

    public int getTankCapacity() {
        return tankCapacity;
    }

    public int getGasLevel() {
        return gasLevel;
    }

    public int kmSinceService() {
        return mileage - lastServiceMileage;
    }

    public void fillTank(int gasAmount) {
        if ((gasLevel + gasAmount) > tankCapacity) {
            throw new GasOverFlowException();
        }
        gasLevel += gasAmount;
    }

    public void service() {
        lastServiceMileage = mileage;
    }

    public boolean needsService() {
        return kmSinceService() > 30000;
    }

    public boolean drive(int d) {
        int gasRequired = Math.round(consumption * d);
        if (gasRequired <= gasLevel) {
            mileage += d;
            gasLevel -= gasRequired;
            return true;
        }
        return false;

    }
}