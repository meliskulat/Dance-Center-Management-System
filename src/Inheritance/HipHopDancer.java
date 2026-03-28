package Inheritance;

import Interfaces.Trainable;
import SystemClassAndMain.Instructor;

public class HipHopDancer extends Dancer implements Trainable {
 private String style;
 private String crewName;

 public HipHopDancer(String name, int age, int experienceYear, Instructor instructor, String style, String crewName) {
     super(name, age, experienceYear, instructor);
     this.style = style;
     this.crewName = crewName;
 }

 // Overridden abstract method
 @Override
 public void perform() {
     System.out.println(getName() + " is performing in HipHop style and belongs to the " + crewName + " crew.");
 }

 // Trainable interface method
 @Override
 public void train() {
     System.out.println(getName() + " is working on breakdance and popping techniques.");
 }


 @Override
 public String toString() {
     return super.toString() +
            "Style           : " + style + "\n" +
            "Crew            : " + crewName + "\n" +
            "----------------------------------";
 }

}