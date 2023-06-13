package org.example;

public class Main {
    public static void main(String[] args) {
        final int semesterDays = 105; // TOOD: pobierz liczbę od użytkownika
        final int initialNumberOfStudents = 40; // TOOD: pobierz liczbę od użytkownika

        Semester semester = new Semester(semesterDays, StudentGenerator.createRandomStudent(initialNumberOfStudents));
        semester.run();
    }

}
