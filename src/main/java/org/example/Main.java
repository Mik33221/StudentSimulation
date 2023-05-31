package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n\nSemester begins...");
        final int initialNumberOfStudents = 8; // TOOD: pobierz liczbę od użytkownika
        List<Student> studentList = StudentGenerator.createRandomStudent(initialNumberOfStudents); // 1. Java: metody z małej litery 2. Generator nie przechowuje stanu, więc ma tylko statyczne metody
        printStudentList(studentList);


        System.out.println("\n\nStudents' live going on...");
        final int days = 105;
        for (int i = 0; i < days; i++) {
            for (Student student : studentList) {
                EventGenerator.generateRandomEvent().modifyStudent(student);
            }
        }
        printStudentList(studentList);

        System.out.println("\n\nSession started...");
        System.out.println("\n\nSemester ended...");

    }

    static void printStudentList(List<Student> students) {
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
