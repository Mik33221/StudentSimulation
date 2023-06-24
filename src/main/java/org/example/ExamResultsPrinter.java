package org.example;

import java.util.List;

/**
 * wykorzystywana w procesie tworzenia tabeli ocen z egzaminu.
 */
public class ExamResultsPrinter {
    private int[] examGrades;
    private int studentId;

    /**
     * @param studentId index studenta
     * @param examGrades tablica ocen
     */
    public ExamResultsPrinter(int studentId, int[] examGrades) {
        this.examGrades = examGrades;
        this.studentId = studentId;
    }
    /**
     *  wyświetla tabelę zawierającą oceny studentów
     */
    public void printResults() {
        String logMessage = String.format("%9d | %10d | %7d | %3d\n",
                studentId, examGrades[0], examGrades[1], examGrades[2]);
        //System.out.println(logMessage);  // Wyświetlenie logu w konsoli
        //SemesterLogger.log(logMessage);  // Zapis logu do pliku tekstowego
    }
}

