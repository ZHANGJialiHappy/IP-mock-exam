import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ServiceCenter {
    private List<Car> serviceQueue;
    private Map<String, Integer> carsPriority;
    private int gasPrice;

    public ServiceCenter(int gasPrice) {
        this.gasPrice = gasPrice;
        serviceQueue = new ArrayList<>();
        carsPriority = new HashMap<>();
    }

    public void addToServiceQueue(Car c) {
        String plate = c.getPlate();
        if (!carsPriority.containsKey(plate)) {
            System.out.println(String.format("Car %s not found", plate));
        } else {
            serviceQueue.add(c);
        }
    }

    public int fillGas(Car c) {
        int gasAmount = c.getTankCapacity() - c.getGasLevel();
        c.fillTank(gasAmount);
        return gasPrice * gasAmount;
    }

    public void updatePriority(Car c, int p) {
        carsPriority.put(c.getPlate(), p);
    }

    public void serviceCar(Car c) {
        if (c.needsService()) {
            c.service();
            System.out.println(String.format("Car %s serviced for %d dollars", c.getPlate(), fillGas(c) + 500));
        }
    }

    public void serviceAll() {
        Iterator<Car> it = serviceQueue.iterator();
        while (it.hasNext()) {
            serviceCar(it.next());
            it.remove();
        }
    }

    public int findHighestPriority() {
        int indexOfCar = -1;
        // // Method1:
        // int highestPriority = 0;
        // for (int i = 0; i < serviceQueue.size(); i++) {
        // int priority = carsPriority.get(serviceQueue.get(i).getPlate());
        // if (priority > highestPriority) {
        // highestPriority = priority;
        // indexOfCar = i;
        // }
        // }
        // Method2:
        int highestPriority = Collections.max(carsPriority.values());
        for (int i = 0; i < serviceQueue.size(); i++) {
            if (carsPriority.get(serviceQueue.get(i).getPlate()).equals(highestPriority)) {
                indexOfCar = i;
            }
        }
        return indexOfCar;
    }

    public void serviceAllWithPriority() {
        // //Method1:
        // while (!serviceQueue.isEmpty()) {
        // Car carWithHighstPriority = serviceQueue.get(findHighestPriority());
        // serviceCar(carWithHighstPriority);
        // serviceQueue.remove(findHighestPriority());
        // }

        // //Method2:
        // Sort Method1:
        serviceQueue.sort((c1, c2) -> carsPriority.get(c2.getPlate()).compareTo(carsPriority.get(c1.getPlate())));
        // //Sort Method2:
        // Collections.sort(this.serviceQueue,
        // Comparator.comparingInt(car -> this.carsPriority.get(((Car)
        // car).getPlate())).reversed());
        serviceAll();

    }
}
