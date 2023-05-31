package org.example;


public class Student extends Person {
    final int indexNumber;

    public Student(String name, String surName, int health, int indexNumber) {
        super(name, surName, health);
        this.indexNumber = indexNumber;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", health=" + health +
                ", indexNumber=" + indexNumber +
                ", Skills=[" + getSkillsAsString() + "]" +
                '}';
    }
}
