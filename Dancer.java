package Inheritance;

import SystemClassAndMain.Instructor;


public abstract class Dancer {
	
	private int dancerID;
 private String name;
 private int age;
 private int experienceYear;
 private Instructor instructor;
 

 private int nextId = 1;

 public Dancer(String name, int age, int experienceYear, Instructor instructor) {
    
     this.dancerID = generateId(); 
     this.name = name;
     this.age = age;
     this.experienceYear = experienceYear;
     this.instructor = instructor;
 }
 

 public int generateId() {
     return nextId++;
 }

 public abstract void perform(); 


 public String getExperienceLevel() {
     if (experienceYear < 2) {
         return "Beginner";
     } else if (experienceYear < 5) {
         return "Intermediate";
     } else {
         return "Expert";
     }
 }

 
 @Override
 public String toString() {
     return  "----------------------------------\n" +
             "Dancer ID       : " + dancerID + "\n" +
             "Name            : " + name + "\n" +
             "Age             : " + age + "\n" +
             "Experience Year : " + experienceYear + "\n" +
             "Level           : " + getExperienceLevel() + "\n" +
             "Instructor      : \n" +
             instructor.toString();
 }
 
 // Necessary Getters
 public int getDancerID() {
     return dancerID;
 }

 public String getName() {
     return name;
 }

 public int getExperienceYear() {
     return experienceYear;
 }
}