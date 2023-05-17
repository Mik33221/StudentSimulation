package org.example;

import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        StudentGenerator Liceum = new StudentGenerator();
        List<Student> studentList = Liceum.CreateRandom(3);
        //System.out.println(studentList.toString());
        //System.out.println(studentList.get(1).getHealth());
    }
}