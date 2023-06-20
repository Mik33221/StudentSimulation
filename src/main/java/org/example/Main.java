package org.example;

/**
 * klasa, w której wpisujemy dane potrzebne do przeprowadzenia symulacji, takie jak ilość studentów i czas trwania semestru.
 */
public class Main {
    public static void main(String[] args) {
        final int semesterDays = 105; // TOOD: pobierz liczbę od użytkownika
        final int initialNumberOfStudents = 5; // TOOD: pobierz liczbę od użytkownika

        /**
         * Stworzenie obiektu semestr
         */
        Semester semester = new Semester(semesterDays, StudentGenerator.createRandomStudent(initialNumberOfStudents));
        /**
         * funkcja semsetr
         */
        semester.run();
    }

}
