import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {
    private String userIP;
    private int level;

    public User(int level) {
        this.level = level;
    }

    private boolean checkIPValidity(String ip) {
        Pattern pattern = Pattern.compile("99\\d*\\.\\d+\\.\\d+\\.\\d+");
        Matcher matcher = pattern.matcher(ip);
        boolean result = matcher.matches();
        return result;
    }

    public void setIP(String ip) {
        if (checkIPValidity(ip)) {
            userIP = ip;
        }
    }

    public String getIP() {
        return userIP;
    }
}