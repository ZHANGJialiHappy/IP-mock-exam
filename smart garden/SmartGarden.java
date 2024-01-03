import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class SmartGarden {
    private int roomLight, waterTankLevel;
    private List<Plant> plants;

    public SmartGarden(int roomLight, int waterTankLevel) {
        this.roomLight = roomLight;
        this.waterTankLevel = waterTankLevel;
        plants = new ArrayList<>();
    }

    public void addPlant(Plant plant) {
        plants.add(plant);
    }

    public void waterPlants() {
        for (Plant p : plants) {
            int requiredWater = p.getRequiredWater();
            if (requiredWater > waterTankLevel) {
                throw new LowWaterLevelException("there is not enough water");
            }
            p.water(requiredWater);
            waterTankLevel -= requiredWater;
        }
    }

    public void checkLighting() {
        for (Plant p : plants) {
            int optimalLightingLevel = p.getOptimalLightingLevel();
            String name = p.getName();
            if (optimalLightingLevel > roomLight) {
                System.out.println(String.format("plant %s requires more light", name));
            } else if (optimalLightingLevel < roomLight) {
                System.out.println(String.format("plant %s requires less light", name));
            } else {
                System.out.println(String.format("plant %s has the perfect amount of light", name));
            }
        }
    }

    public Map<Plant, Integer> numberOfPlants() {
        Map<Plant, Integer> plantsWithQuantity = new HashMap<>();
        for (Plant p : plants) {
            Integer number = 1;
            if (plantsWithQuantity.containsKey(p)) {
                number += plantsWithQuantity.get(p);
            }
            plantsWithQuantity.put(p, number);
        }
        return plantsWithQuantity;
    }

    public void printReport() {
        // for (Entry<Plant, Integer> entry : numberOfPlants().entrySet()) {
        // entry.getKey().printReport();
        // }
        for (Plant p : numberOfPlants().keySet()) {
            p.printReport();
        }
    }

}
