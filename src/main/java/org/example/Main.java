package org.example;

import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        StudentGenerator liceum = new StudentGenerator();
        List<Student> studentList = liceum.CreateRandom(3);

        Party party = new Party();
        Study study = new Study();
        Work work = new Work();
        System.out.println(studentList.get(0).toString());

        for(Student student:studentList){
            ;
        }

        //System.out.println(studentList.toString());
        //System.out.println(studentList.get(1).getHealth());
    }
}