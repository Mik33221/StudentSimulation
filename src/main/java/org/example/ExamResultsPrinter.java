package org.example;
import java.util.List;


public class ExamResultsPrinter {
    private int[] examGrades;
    private int studentId;
    private SemesterLogger logger;

    public ExamResultsPrinter(int studentId,int[] examGrades,  SemesterLogger logger) {
        this.examGrades = examGrades;
        this.studentId = studentId;
        this.logger = logger;
    }
    public void printResults() {
        String logMessage =String.format("%9d | %10d | %7d | %3d\n",
            studentId, examGrades[0], examGrades[1], examGrades[2]);
        //System.out.println(logMessage);  // Wyświetlenie logu w konsoli
        logger.log(logMessage);  // Zapis logu do pliku tekstowego
        }
}

