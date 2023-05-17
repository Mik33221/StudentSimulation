package org.example;

public class Student {
    public Student(){
        health = 100;
        luck = 0;
        perception = 0;
        System.out.println("Empty created");
    }
    public Student(int health, int luck, int perception){
        this.health = health;
        this.luck = luck;
        this.perception = perception;
        System.out.println("Student: health - "+health+" luck - "+luck+" perception - "+perception);
    }
    private int health;
    private int luck;
    private int perception;

    public int getHealth() {
        return health;
    }

    public int getLuck() {
        return luck;
    }

    public int getPerception() {
        return perception;
    }

    public void setHealth(int health) {
        this.health = health;
    }

}
