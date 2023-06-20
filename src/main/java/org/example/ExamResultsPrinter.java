package org.example;
import java.util.List;

/**
 * wykorzystywana w procesie tworzenia tabeli ocen z egzaminu.
 */
public class ExamResultsPrinter {
    private int[] examGrades;
    private int studentId;

    /**
     *
     * @param studentId przekazujemy mu index studenta, oraz tablicę ocen.
     * @param examGrades obiekt ExamResultsPrinter
     */
    public ExamResultsPrinter(int studentId,int[] examGrades) {
        this.examGrades = examGrades;
        this.studentId = studentId;
    }

    /**
     *  wyświetla wyświetla zawartość tabeli stworzonej w klasie examSession
     */
    public void printResults() {
        System.out.printf("%9d | %10d | %7d | %3d\n",
            studentId, examGrades[0], examGrades[1], examGrades[2]);
        }
}

