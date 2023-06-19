package org.example;

public class Main {
    public static void main(String[] args) {
        final int semesterDays = 105; // TOOD: pobierz liczbę od użytkownika
        final int initialNumberOfStudents = 5; // TOOD: pobierz liczbę od użytkownika
        String logFilePath = "semester.log";

        Semester semester = new Semester(semesterDays, StudentGenerator.createRandomStudent(initialNumberOfStudents), logFilePath);
        semester.run();
    }

}
