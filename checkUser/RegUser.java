import java.util.Arrays;

public class RegUser extends User {
    private int region;

    public RegUser(int level, int region) {
        super(level);
        this.region = region;
    }

    private boolean checkIPValidity(String ip) {
        boolean isValided = true;
        String[] ipList = ip.split("\\.");
        for (String subIp : ipList) {
            if (subIp.equals("111")) {
                isValided = false;
            }
        }
        return isValided;
    }

    public void setIP(String ip) {
        if (checkIPValidity(ip)) {
            super.setIP(ip);
        }
    }

}
