import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class PostServicePoint {
    private Item[] registeredItems;
    private List<Item> processedItems;
    private int maxWeight, count;

    public PostServicePoint(int maxWeight) {
        registeredItems = new Item[10];
        processedItems = new ArrayList<>();
        this.maxWeight = maxWeight;
        count = 0;
    }

    public void register(Item item) {
        if (count == 10) {
            System.out.println("no available capacity!");
        } else {
            registeredItems[count] = item;
            count += 1;
        }
    }

    public boolean checkItemAddress(String adr) {
        return adr.length() < 20;
    }

    public boolean checkItemWeight(int wgh) {
        return wgh < maxWeight;
    }

    public void printPrice(int i) {
        if (registeredItems[i] != null) {
            int price = (int) (Math.ceil((double) (registeredItems[i].getWeight()) / 2) * 12);
            System.out.println(String.format("The price for sending is: %d", price));
        }
    }

    public void printAllPrices() {
        for (int i = 0; i < registeredItems.length; i++) {
            printPrice(i);
        }
    }

    public void processOne() {
        if (count == 0) {
            return;
        }
        boolean isAddressValid = checkItemAddress(registeredItems[count - 1].getAddress());
        boolean isWeightValid = checkItemWeight(registeredItems[count - 1].getWeight());

        if (isAddressValid && isWeightValid) {
            processedItems.add(registeredItems[count - 1]);
        }
        if (!isAddressValid) {
            System.out.println("invalid address!");
        }
        if (!isWeightValid) {
            System.out.println("invalid weight!");
        }
        registeredItems[count - 1] = null;
        count--;
    }

    public void processAll() {
        int total = count;
        for (int i = 0; i < total; i++) {
            processOne();
        }
    }

    public int totalweight() {
        int totalWeight = 0;
        for (Item i : processedItems) {
            totalWeight += i.getWeight();
        }
        return totalWeight;
    }

    public Map<String, Integer> checkCategories() {
        Map<String, Integer> categoriesMap = new HashMap<>();
        for (Item i : processedItems) {
            String category = i.getCategory();
            int number = 1;
            if (categoriesMap.containsKey(category)) {
                number += categoriesMap.get(category);
            }
            categoriesMap.put(category, number);
        }
        return categoriesMap;
    }

    public void removeCategory(String c) {
        Iterator<Item> it = processedItems.iterator();
        while (it.hasNext()) {
            Item item = it.next();
            if (item.getCategory().equals(c)) {
                it.remove();
            }
        }
    }
}
