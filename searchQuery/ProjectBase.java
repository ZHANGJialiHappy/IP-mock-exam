import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ProjectBase {
    private List<String> projectTitles;

    public ProjectBase(List<String> projectTitles) {
        this.projectTitles = projectTitles;
    }

    public void addTitle(String t) {
        projectTitles.add(t);
    }

    public Set<String> search(String query) {
        // Method1:
        Set<String> titles = new HashSet<>();
        for (String t : projectTitles) {
            if (t.contains(query)) {
                titles.add(t);
            }
        }
        // // Method2:
        // Set<String> titles = projectTitles.stream()
        // .filter(t -> t.contains(query))
        // .collect(Collectors.toSet());

        return titles;
    }

    public List<String> getProjectTitles() {
        return projectTitles;
    }
}