package Inheritance;

import Interfaces.Trainable;
import SystemClassAndMain.Instructor;

public class BalletDancer extends Dancer implements Trainable {
    private String shoeType;
    private String techniqueLevel;

    public BalletDancer(String name, int age, int experienceYear, Instructor instructor, String shoeType, String techniqueLevel) {
        super(name, age, experienceYear, instructor);
        this.shoeType = shoeType;
        this.techniqueLevel = techniqueLevel;
    }

    // Overridden abstract method
    @Override
    public void perform() {
        System.out.println(getName() + " is performing Ballet, using " + shoeType + " shoes and " + techniqueLevel + " technique.");
    }

    // Trainable interface method
    @Override
    public void train() {
        System.out.println(getName() + " is practicing pirouettes and adagio movements.");
    }

    @Override
    public String toString() {
        return super.toString() +
               "Shoe Type       : " + shoeType + "\n" +
               "Technique Level : " + techniqueLevel + "\n" +
               "----------------------------------";
    }
}