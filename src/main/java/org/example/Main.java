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

        Random random = new Random();

        int deepDecisionMakingAlgorithm;

        int days = 7;
        for (int i = 0; i < days; i++) {
            for(Student student:studentList){
                deepDecisionMakingAlgorithm = random.nextInt(3);
                switch (deepDecisionMakingAlgorithm){
                    case 0:
                        party.ModifyStudent(student);
                        break;
                    case 1:
                        study.ModifyStudent(student);
                        break;
                    case 2:
                        work.ModifyStudent(student);
                        break;
                    default:
                        System.out.println("Decision making error");
                }
            }
        }

        System.out.println(studentList.toString());
    }
}