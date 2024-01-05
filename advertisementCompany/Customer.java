import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Customer {
    private Set<String> preferences;
    private List<String> advertisements;
    private int maxAdvs;

    public Customer(Set<String> preferences, int maxAdvs) {
        this.preferences = preferences;
        this.maxAdvs = maxAdvs;
        advertisements = new ArrayList<>();
    }

    public Set<String> getPreferences() {
        return preferences;
    }

    public boolean addAdvertisement(String adv) {
        if ((advertisements.size() + 1) <= maxAdvs) {
            advertisements.add(adv);
            return true;
        } else {
            return false;
        }
    }

    public void addPreferences(String[] newPreferences) {
        for (String np : newPreferences) {
            preferences.add(np);
        }
    }

    public void remove(String pref) {
        preferences.remove(pref);
    }

    public void readAdvertisements(int n) {
        int endIndex = advertisements.size() - n;
        if (endIndex < 0) {
            endIndex = advertisements.size();
        }
        for (int i = advertisements.size() - 1; i >= endIndex; i--) {
            System.out.println(advertisements.get(i));
            advertisements.remove(i);
        }
    }

}