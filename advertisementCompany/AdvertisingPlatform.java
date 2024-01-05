import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
// import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AdvertisingPlatform {
    private List<Customer> subscribers;
    private Set<String> forbiddenWords;

    public AdvertisingPlatform(Set<String> forbiddenWords) {
        subscribers = new ArrayList<>();
        this.forbiddenWords = forbiddenWords;
    }

    public void addCustomer(Customer cm) {
        if (subscribers.contains(cm)) {
            System.out.println("customer already exists!");
        } else {
            subscribers.add(cm);
            System.out.println("customer is added!");
        }
    }

    public void publishAdv(String adv, Customer cm) {
        // should I toLowerCase(). ??
        String[] advWords = adv.split(" ");
        for (String w : advWords) {
            if (cm.getPreferences().contains(w)) {
                cm.addAdvertisement(adv);
            }
        }
    }

    public boolean checkValidity(String adv) {
        // should I toLowerCase(). ??
        String[] advWords = adv.split(" ");
        System.out.println(Arrays.toString(advWords));
        boolean isValided = true;
        if (advWords.length <= 20) {
            for (String w : advWords) {
                if (forbiddenWords.contains(w)) {
                    isValided = false;
                }
            }
        }
        return isValided;
    }

    public void publishToAll(String adv) {
        if (checkValidity(adv)) {
            for (Customer c : subscribers) {
                publishAdv(adv, c);
            }

        }
    }

    public static void main(String[] args) {
        Customer c = new Customer(new HashSet<>(), 4);
        c.addAdvertisement("adv1");
        System.out.println(c.addAdvertisement("adv2"));
        System.out.println(c.addAdvertisement("adv3"));
        System.out.println(c.addAdvertisement("adv4"));

        String[] np = { "1", "1", "2" };
        c.addPreferences(np);
        c.remove("3");
        c.readAdvertisements(2);
        // Set<String> forbiddenWords = new HashSet<>();
        // forbiddenWords.add("3");
        // AdvertisingPlatform ap = new AdvertisingPlatform(forbiddenWords);
        // ap.addCustomer(c);
        // ap.addCustomer(c);
        // ap.publishAdv("se se tr", c);
        // ap.publishAdv("1", c);
        // System.out.println(ap.checkValidity(" 4 5"));
        // ap.publishToAll("3");
        // System.out.println(c.advertisements);

    }
}
