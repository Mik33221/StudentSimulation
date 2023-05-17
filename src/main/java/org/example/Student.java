package org.example;

import java.util.HashMap;

public class Student {
    public Student(){
        health = 100;
        name = "blank";
        surName = "blank";
        System.out.println("Blank created");
    }
    public Student(String name, String surName, int health){
        this.health = health;
        this.name = name;
        this.surName = surName;
        System.out.println("Student: "+name+" "+surName+ " health: "+ health);
    }
    private String name;
    private String surName;
    private int health;
    private HashMap<String, Integer> skills = new HashMap<String, Integer>();
    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public HashMap getSkills(){
        return skills;
    }

}
