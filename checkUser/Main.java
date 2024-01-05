public class Main {
    private int count;

    public void myMethod(int count) {
        ++count;
        System.out.println(count);
    }

    public int get() {
        return count;
    }

    public static void main(String[] args) {
        // User a = new RegUser(0, 2);
        // a.setIP("990.123.12.111");
        // System.out.println(a.getIP());
        Main c = new Main();
        c.myMethod(0);
        System.out.println(c.get());
    }
}
