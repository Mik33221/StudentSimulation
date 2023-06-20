package org.example;


import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * Klasa dziedzicząca po Person, dodaje obiektowi cechy charakterystyczne dla studenta
 */
public class Student extends Person {
    /**
     *  numer indeksu
     */
    final int indexNumber;
    /**
     *  Status studenta
     */
    private StudentState state;
    /**
     * tablica ocen
     */
    private int[] examGrades;
    /**
     * mapa predyspozycji do nauki
     */
    private final HashMap<String, Integer> predispositions; // tablica na wartości które mają wpływać na decyzje studentan, nie modyfikowane

    public Student(String name, String surName, int health, int money, int indexNumber,
                   HashMap<String, Integer> predispositions, int[] ExamGrades, String status) {
        super(name, surName, health, money);
        this.indexNumber = indexNumber;
        this.state = StudentState.ACTIVE;
        this.predispositions = (HashMap<String, Integer>) predispositions.clone();
        this.social = this.predispositions.get("InitialSocialization");
        this.examGrades = examGrades;
    }

    public StudentState getState() {
        return state;
    }

    public void setState(StudentState state) {
        this.state = state;
    }
    /**
     * zwraca tablice predyspozycji
     * @return tab
     */
    public int[] getAllPredispositions(){
        int[] tab = {
                this.predispositions.get("Math"),
                this.predispositions.get("Physics"),
                this.predispositions.get("IT"),
                social
        };
        return tab;
    }

    /**
     * zwraca sumę predyspozycji
     * @return sum
     */
    public int getSumPredispositions(){
        int[] tab = getAllPredispositions();
        int sum = IntStream.of(tab).sum();
        return sum;
    }

    /**
     * Zwraca numer indeksu
     * @return indexNumber
     */
    public int getIndexNumber(){
        return indexNumber;
    }
    /**
     * Resetuje zmienną social do wartości początkowej
     */
    public void resetSocial(){
        this.social = this.predispositions.get("InitialSocialization");
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", health=" + health +
                ", money=" + money +
                ", social=" + social +
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
    public void setExamGrades(int[] examGrades) {
        this.examGrades = examGrades;
    }
    public int[] getExamGrades(){
        return examGrades;
    }

    public boolean isActive() {
        return getState() == StudentState.ACTIVE;
    }

    public boolean isNotActive() {
        return getState() == StudentState.DELETED;
    }
}

