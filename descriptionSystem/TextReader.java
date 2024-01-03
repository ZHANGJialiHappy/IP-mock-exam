import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextReader {
    private String text;

    public TextReader(String text) {
        this.text = text;
    }

    public void replace(String s, String t) {
        Pattern pattern = Pattern.compile(s);
        Matcher matcher = pattern.matcher(text);
        text = matcher.replaceAll(t);

        // text = text.replaceAll(s, t);

        // String[] words = text.trim().split(" ");
        // text = "";
        // for (int i = 0; i < words.length; i++) {
        // if (words[i].equals(s)) {
        // words[i] = t;
        // }
        // }
        // String separator = "";
        // for (String w : words) {
        // text += separator + w;
        // separator = " ";
        // }
        System.out.println(text);
    }

    public Map<String, Integer> counts() {
        String[] words = text.trim().split(" ");
        Map<String, Integer> wordsMap = new HashMap<>();
        for (String w : words) {
            // Integer occurrence = 1;
            // if (wordsMap.containsKey(w)) {
            // occurrence += wordsMap.get(w);
            // }
            // wordsMap.put(w, occurrence);

            // wordsMap.merge(w, 1, (oldValue, newValue) -> oldValue + newValue);

            wordsMap.merge(w, 1, Integer::sum);
        }
        return wordsMap;
    }

}