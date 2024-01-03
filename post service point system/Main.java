public class Main {
    public static void main(String[] args) {
        Item z = new Item("a", "address1", 50);

        Item a = new Item("a", "address1", 500);
        Item b = new Item("a", "address112", 5);
        Item c = new Item("a", "address1", 10);
        Item d = new Item("b", "address1", 10);

        PostServicePoint postoffice = new PostServicePoint(100);
        postoffice.register(z);

        postoffice.register(a);
        postoffice.register(b);
        postoffice.register(c);
        postoffice.register(d);
        postoffice.register(d);

        // System.out.println(postoffice.checkItemAddress("12345678901234567890"));
        // System.out.println(postoffice.checkItemWeight(100));
        // postoffice.printPrice(1);
        postoffice.printAllPrices();
        postoffice.processAll();
        System.out.println(postoffice.totalweight());
        System.out.println(postoffice.checkCategories());
        postoffice.removeCategory("a");
        System.out.println("...");
        System.out.println(postoffice.checkCategories());
    }
}
