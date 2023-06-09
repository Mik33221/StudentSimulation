package org.example;
import java.util.List;
import java.lang.System;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n\nSemester begins...");
        final int initialNumberOfStudents = 8;
        List<Student> studentList = StudentGenerator.createRandomStudents(initialNumberOfStudents);
        printStudentList(studentList);
        System.out.println("\n\nStudents' live going on...");

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

    private static void printStudentList(List<Student> studentList) {
        for (Student student : studentList) {
            System.out.println(student);
        }
    }
}