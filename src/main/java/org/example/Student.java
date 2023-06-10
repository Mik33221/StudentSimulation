package org.example;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

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
    public int[] getAllPredispositions(){
        int[] tab = {
                this.predispositions.get("Math"),
                this.predispositions.get("Physics"),
                this.predispositions.get("IT"),
                this.predispositions.get("Socialization")
        };
        return tab;
    }
    public int getSumPredispositions(){
        int[] tab = getAllPredispositions();
        int sum = IntStream.of(tab).sum();
        return sum;
    }
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", health=" + health +
                ", indexNumber=" + indexNumber +
                ", state=" + state +
                ", \nSkills=[" + getSkillsAsString() + "]" +
                ", \nPreds=[" + getPredispositionsAsString() + "]" +
                '}';
    }
    public String getPredispositionsAsString() {
        StringBuilder stringBuffer = new StringBuilder();
        for (Map.Entry<String, Integer> entry : this.predispositions.entrySet()) {
            stringBuffer
                    .append("[Pred=").append(entry.getKey())
                    .append(", value=").append(entry.getValue()).append("],");
        }
        return stringBuffer.toString();
    }
}
