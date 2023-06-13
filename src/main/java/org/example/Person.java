package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Person {
    protected String name; // private => protected by dziedziczaca klasa Student mogła na tym operować
    protected String surName;
    protected int health; // trzy zmienne, najczęściej edytowane
    protected int money;
    protected int social;
    private final HashMap<String, Integer> skills = new HashMap<>(); // hermetyczna dana - zmieniana tylko przez metodę
                                                                     // tablica na skille, student zyskuje je w trakcie semestru, nie może tracić
    public Person(String name, String surName) {
        this(name, surName, 100,0);
    }

    public Person(String name, String surName, int health, int money) {
        this.name = name;
        this.surName = surName;
        this.health = health;
        this.money = money;
        this.skills.put("Math",0);
        this.skills.put("Physics",0);
        this.skills.put("IT",0);
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
    public int getMoney(){
        return money;
    }
    public int getSocial(){
        return social;
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
    public void increaseMoney(int value) {
        if (this.money + value <= 10000) {
            this.money += value;
        } else {
            this.money = 10000;
        }
    }
    public void decreaseMoney(int value) {
        if (this.money - value >= 0) {
            this.money -= value;
        } else {
            this.money = 0;
        }
    }
    public void increaseSocial(int value) {
        if (this.social + value <= 1000) {
            this.social += value;
        } else {
            this.social = 1000;
        }
    }
    public void decreaseSocial(int value) {
        if (this.social - value >= 0) {
            this.social -= value;
        } else {
            this.social = 0;
        }
    }

    public void increaseSkill(String skill){
        if (this.skills.get(skill)>30){
            this.skills.merge(skill, 1, (oldValue, newValue) -> oldValue + newValue);
        } else{
            this.skills.merge(skill, 2, (oldValue, newValue) -> oldValue + newValue);
        }
        decreaseMoney(40);
        increaseSocial(new Random().nextInt(2,4));
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