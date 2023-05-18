package org.example;

import com.sun.source.tree.Tree;

import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        StudentGenerator liceum = new StudentGenerator();
        List<Student> studentList = liceum.CreateRandom(8);

        System.out.println(studentList.get(0).toString());

        Random random = new Random();

        int deepDecisionMakingAlgorithm;

        ArrayList<Event> events = new ArrayList<>();

        events.add(new Work());
        events.add(new Party());
        events.add(new StudyIT());
        events.add(new StudyMath());
        events.add(new StudyPhysics());

        int days = 120;
        for (int i = 0; i < days; i++) {
            for(Student student:studentList){
                deepDecisionMakingAlgorithm = random.nextInt(events.size());
                events.get(deepDecisionMakingAlgorithm).ModifyStudent(student);
                }
            }

        System.out.println(studentList.toString());
    }
}
