public class Main {
    public static void main(String[] args) {
        SmartGarden s = new SmartGarden(100, 100);
        Plant p1 = new Plant("p1", 20, 40, 110);
        Plant p2 = new Plant("p2", 20, 40, 100);

        s.addPlant(p1);
        s.addPlant(p1);
        s.addPlant(p2);

        s.checkLighting();
        System.out.println(s.numberOfPlants());

        s.printReport();
    }

}
