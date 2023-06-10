package org.example;


import java.util.Collection;
import java.util.HashMap;

public class Student extends Person {
    final int indexNumber;
    final StudentState state;
    private final HashMap<String, Integer> predispositions; // tablica na wszystkie wartości które mają wpływać na decyzje studenta
    public Student(String name, String surName, int health, int indexNumber, HashMap<String, Integer> predispositions) {
        super(name, surName, health);
        this.indexNumber = indexNumber;
        this.state = StudentState.ACTIVE;
        this.predispositions = (HashMap<String, Integer>) predispositions.clone();
    }
    public Integer getPredisposition(String pred){
        return this.predispositions.get(pred);
    }
    public Integer[] getAllPredispositions(){
        Integer[] tab = {
                this.predispositions.get("Math"),
                this.predispositions.get("Physics"),
                this.predispositions.get("It"),
                this.predispositions.get("Socialization")
        };
        return tab;
    }
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", health=" + health +
                ", indexNumber=" + indexNumber +
                ", state=" + state +
                ", Skills=[" + getSkillsAsString() + "]" +
                '}';
    }
}
