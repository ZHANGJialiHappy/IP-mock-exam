public class Main {

    public static void main(String[] args) {
        Car a = new Car("DK1", 100000, 1.23f);
        Car c = new Car("DK2", 10000, 1.23f);

        a.fillTank(100000);
        System.out.println(a.drive(40000));
        // System.out.println("...");
        // System.out.println(a.needsService());
        // a.service();
        // a.drive(35000);
        // System.out.println(a.needsService());

        // double x = -1.8;
        // float y = (float) x;
        // System.out.println(Math.ceil(y));
        ServiceCenter s = new ServiceCenter(100);
        s.updatePriority(a, 3);
        s.updatePriority(c, 2);
        s.addToServiceQueue(a);
        s.addToServiceQueue(c);
        // System.out.println(s.fillGas(a));
        // s.serviceAll();
        System.out.println(s.findHighestPriority());
        s.serviceAllWithPriority();
    }
}
