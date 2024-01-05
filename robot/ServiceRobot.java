import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ServiceRobot extends Robot {
    private Map<String, Integer> taskInfo;

    public ServiceRobot(int m, int b, int c) {
        super(m, b, c);
        taskInfo = new HashMap<>();
    }

    public void defineTask() {
        Scanner sc = new Scanner(System.in);
        String taskName = sc.nextLine();
        if (sc.hasNextLine()) {
            Integer requiredEnergy = sc.nextInt();
            if (requiredEnergy < 0 || requiredEnergy > super.getMaxLevel()) {
                sc.close();
                throw new IllegalArgumentException("The value of required energy is not valid");
            } else {
                taskInfo.put(taskName, requiredEnergy);
                // System.out.println(taskInfo);
            }
        }
        // Scanner can not be closed, otherwise sc.hasNext() will become false, no
        // matter if another scanner is newed.

        // sc.close();
    }

    public void service(int n) {
        int count = 0;
        Scanner sc = new Scanner(System.in);
        // count<n should be before sc.hasNextLine(), in case extra input;
        while (count < n && sc.hasNextLine()) {
            String taskName = sc.nextLine();
            if (!taskInfo.containsKey(taskName)) {
                System.out.println(String.format("Sorry the task %s is not among my definedtasks!", taskName));
            } else {
                if (super.performTask(taskInfo.get(taskName))) {
                    System.out.println(String.format("performing task %s", taskName));
                } else {
                    System.out.println("Sorry I do not have enough battery");
                }
            }
            count++;
        }
        // Scanner can not be closed, otherwise sc.hasNext() will become false, no
        // matter if another scanner is newed.

        // sc.close();

    }

    public void charge() {
        int x = super.timeToCharge();
        System.out.println(String.format("Time to charge is %s minutes", x));
        super.charge();
    }

    public static void main(String[] args) {
        // Robot r = new Robot(10, 20, 1);
        // System.out.println(r.performTask(5));
        // System.out.println(r.timeToCharge());
        ServiceRobot s = new ServiceRobot(10, 30, 1);
        s.defineTask();
        System.out.println("...");
        s.defineTask();
        s.defineTask();

        // s.charge();
        System.out.println("...");
        s.service(2);
        s.defineTask();
        s.service(2);

    }
}
