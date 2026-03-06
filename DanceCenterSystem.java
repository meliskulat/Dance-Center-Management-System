package SystemClassAndMain;
import Inheritance.BalletDancer;
import Inheritance.Dancer;
import Inheritance.HipHopDancer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import Inheritance.Dancer;

public class DanceCenterSystem {

    private static ArrayList<Dancer> dancers = new ArrayList<>();
    private static Set<String> danceTypes = new HashSet<>();
    public static int totalDancers = 0; 

    public static void addDancer(Dancer d) {
        dancers.add(d);
        totalDancers++;
        
        if (d instanceof HipHopDancer) {
            danceTypes.add("HipHop");
        } else if (d instanceof BalletDancer) {
            danceTypes.add("Ballet");
        }
        System.out.println(d.getName() + " has been added to the system.");
    }

    public static void deleteDancer(int id) {
        Dancer foundDancer = null;
        for (Dancer d : dancers) {
            if (d.getDancerID() == id) {
                foundDancer = d;
                break;
            }
        }
        
        if (foundDancer != null) {
            dancers.remove(foundDancer);
            totalDancers--;
            System.out.println("Dancer with ID " + id + " (" + foundDancer.getName() + ") has been removed from the system.");
        } else {
            System.out.println("Dancer with ID " + id + " could not be found.");
        }
    }

    public static Dancer searchByName(String name) {
        for (Dancer d : dancers) {
            if (d.getName().equalsIgnoreCase(name)) {
                return d;
            }
        }
        return null;
    }

    public static String displayAll() {
        StringBuilder sb = new StringBuilder();
        sb.append("--- All Dancers (Total: ").append(totalDancers).append(") ---\n");
        if (dancers.isEmpty()) {
            sb.append("There are no registered dancers in the system.\n");
        } else {
            for (Dancer d : dancers) {
                sb.append(d.toString()).append("\n");
            }
        }
        sb.append("--- Available Dance Types: ").append(danceTypes.toString()).append(" ---\n");
        return sb.toString();
    }

    public static int calculateTotalExperience() {
        int totalExperience = 0;
        for (Dancer d : dancers) {
            totalExperience += d.getExperienceYear();
        }
        return totalExperience;
    }

    public static int getTotalDancers() {
        return totalDancers;
    }
}
