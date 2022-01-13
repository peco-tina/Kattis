package AnomalyDetection1;

import java.util.ArrayList;
import java.util.Scanner;

public class AnomalyDetection {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> log = new ArrayList<>();
        ArrayList<String> employees = new ArrayList<>();

        int numberOfAction = sc.nextInt();
        sc.nextLine();

        for(int i = 0; i < numberOfAction; i++) {
            String s = sc.nextLine();
            String entryOrExit = getEntryOrExit(s);
            String name = getName(s);
            boolean isAnomaly;
            String output;
            if(entryOrExit.equals("entry")){
                output = name.concat(" entered");
                isAnomaly = employees.contains(name);
            } else {
                output = name.concat(" exited");
                isAnomaly = !employees.contains(name);
            }
            if(isAnomaly){
                log.add(output.concat(" (ANOMALY)"));
                continue;
            }
            if(entryOrExit.equals("entry")){
                employees.add(name);
            } else {
                employees.remove(name);
            }
            log.add(output);
        }
        for(String s : log){
            System.out.println(s);
        }
    }

    private static String getName(String s) {
        String name = s.substring(s.indexOf(" ")+1); // tar in namn från string
        return name;
    }

    private static String getEntryOrExit(String s) {
        String entryOrExit = s.substring(0, s.indexOf(" ")); // tar in första ordet;
        return entryOrExit;
    }
}
