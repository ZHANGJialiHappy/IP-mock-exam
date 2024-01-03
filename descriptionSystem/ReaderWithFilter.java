import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReaderWithFilter extends TextReader {
    private List<String> filteredWords;

    public ReaderWithFilter(String text, List<String> filteredWords) {
        super(text);
        this.filteredWords = filteredWords;
    }

    public void filter() {
        for (String f : filteredWords) {
            super.replace(f, "***");
        }
    }

    public Map<String, Integer> counts() {
        Map<String, Integer> wordMap = super.counts();
        for (String w : filteredWords) {
            wordMap.remove(w);
        }
        // filteredWords.forEach(w -> wordMap.remove(w));
        return wordMap;
    }

    public static void main(String[] args) {
        TextReader t = new TextReader("abcd a");
        t.replace("a", "*");
        System.out.println(t.counts());
        List<String> f = new ArrayList<>(Arrays.asList("abc", "a", "asddfgh"));
        ReaderWithFilter r = new ReaderWithFilter("abcd abc ab a ab ab", f);
        r.filter();
        System.out.println("...");
        System.out.println(r.counts());
    }
}
