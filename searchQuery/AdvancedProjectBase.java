import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AdvancedProjectBase extends ProjectBase {

    public AdvancedProjectBase(List<String> projectTitles) {
        super(projectTitles);
    }

    public Set<String> search(String query) {
        String[] queryTerms = query.replaceAll("\\s+", "").split(",");
        Set<String> titles = new HashSet<>();
        for (String q : queryTerms) {
            titles.addAll(super.search(q));
        }
        return titles;
    }

    public List<String> getProjectTitles() {
        List<String> a = new ArrayList<>(Arrays.asList("1", "2"));
        super.getProjectTitles().addAll(a);
        return super.getProjectTitles();
    }

    public static void main(String[] args) {
        List<String> projectTitles = new ArrayList<>(Arrays.asList("a", "b"));
        ProjectBase a = new AdvancedProjectBase(projectTitles);
        System.out.println(a.getProjectTitles());
    }
}
