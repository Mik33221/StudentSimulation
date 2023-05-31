package org.example;

import java.util.HashMap;
import java.util.Map;

public class Person {
    protected String name; // private => protected by dziedziczaca klasa Student mogła na tym operować
    protected String surName;
    protected int health;
    private final HashMap<String, Integer> skills = new HashMap<>(); // hermetyczna dana - zmieniana tylko przez metodę

    public Person(String name, String surName) {
        this(name, surName, 100);
    }

    public Person(String name, String surName, int health) {
        this.health = health;
        this.name = name;
        this.surName = surName;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }
    public int getHealth() {
        return health;
    }

    public void increaseHealth(int value) {
        if (this.health + value <= 100) {
            this.health += value;
        } else {
            this.health = 100;
        }
    }
    public void decreaseHealth(int value) {
        if (this.health - value >= 0) {
            this.health -= value;
        } else {
            this.health = 0;
        }
    }
    public void increaseSkill(String skill){
        this.skills.merge(skill, 1, (oldValue, newValue) -> oldValue + newValue);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", health=" + health +
                '}';
    }

    public String getSkillsAsString() {
        StringBuilder stringBuffer = new StringBuilder();
        for (Map.Entry<String, Integer> entry : this.skills.entrySet()) {
            stringBuffer
                    .append("[Skill=").append(entry.getKey())
                    .append(", value=").append(entry.getValue()).append("],");
        }
        return stringBuffer.toString();
    }
}