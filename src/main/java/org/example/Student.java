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
    final StudentState state;
    /**
     * tablica ocen
     */
    private int[] examGrades;
    /**
     * mapa predyspozycji do nauki
     */
    private final HashMap<String, Integer> predispositions; // tablica na wartości które mają wpływać na decyzje studentan, nie modyfikowane


    /**
     *
     * @param name-dziedziczy po Person
     * @param surName-dziedziczy po Person
     * @param health-dziedziczy po Person
     * @param money-dziedziczy po Person
     * @param indexNumber-nadawane w klasie StudnentGenerator
     * @param predispositions-nadawane w klasie StudnentGenerator
     * @param ExamGrades-nadawane w klasie StudnentGenerator
     * @param status-nadawane w klasie StudnentGenerator
     */
    public Student(String name, String surName, int health, int money, int indexNumber,
                   HashMap<String, Integer> predispositions, int[] ExamGrades, String status) {
        super(name, surName, health, money);
        this.indexNumber = indexNumber;
        this.state = StudentState.ACTIVE;
        this.predispositions = (HashMap<String, Integer>) predispositions.clone();
        this.social = this.predispositions.get("InitialSocialization");
        this.examGrades = examGrades;
    }

    /**
     *
     * @param pred nazwa predyspozycji
     * @return zwraca wartość predyspozycji z danej dziediny
     */
    public int getPredisposition(String pred){
        return this.predispositions.get(pred);
    }

    /**
     *
     * @return tworzy tablice predyspozycji
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
     *
     * @return sumuje wszystkie predyspozycje
     */
    public int getSumPredispositions(){
        int[] tab = getAllPredispositions();
        int sum = IntStream.of(tab).sum();
        return sum;
    }

    /**
     * Resetuje zmienną social do wartości początkowej
     */
    public void resetSocial(){
        this.social = this.predispositions.get("InitialSocialization");
    }

    /**
     *
     * @return zapisuje w przypisane cechy studenta w postaci łańcucha znaków
     */
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

    /**
     *
     * @return Zwraca Stringa z wartościami predyspozyvji
     */
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
}

