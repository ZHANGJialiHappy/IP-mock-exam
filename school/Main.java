import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void printInfo(List<Person> persons) {
        for (Person p : persons) {
            System.out.println(p);
        }
    }

    public static void main(String[] args) {
        List<Person> ps = new ArrayList<>();
        Person p1 = new Person("jiali", "0123456789");
        ps.add(p1);
        printInfo(ps);
    }
}
