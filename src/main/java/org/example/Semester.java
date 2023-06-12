package org.example;

import org.example.events.EventGenerator;

import java.util.List;

public class Semester {
    final int days;
    final List<Student> studentList;

    public Semester(int days, List<Student> studentList) {
        this.days = days;
        this.studentList = studentList;
    }

    public void run() {
        System.out.println("\n\nSemester begins...");

        System.out.println("\n\nStudents' live going on...");
        for (int i = 0; i < this.days; i++) {
            for (Student student : this.studentList) {
                EventGenerator.generateRandomEvent(student).modifyStudent(student);
            }
        }

        System.out.println("\n\nSession started...");
        System.out.println("\n\nSemester ended...");

    }

    public void printStudentStateList() {
        for (Student student : this.studentList) {
            System.out.println(student);
        }
    }
}
