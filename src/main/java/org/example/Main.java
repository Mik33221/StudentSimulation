package org.example;

public class Main {
    /**
     * Klasa rozpoczynająca symulację
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        final int semesterDays = 105; // TOOD: pobierz liczbę od użytkownika
        final int initialNumberOfStudents = 5; // TOOD: pobierz liczbę od użytkownika

        Semester semester = new Semester(semesterDays, StudentGenerator.createRandomStudent(initialNumberOfStudents));
        semester.run();
    }

}
