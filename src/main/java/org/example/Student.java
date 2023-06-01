package org.example;


public class Student extends Person {
    final int indexNumber;
    final StudentState state;

    public Student(String name, String surName, int health, int indexNumber) {
        super(name, surName, health);
        this.indexNumber = indexNumber;
        this.state = StudentState.ACTIVE;
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
