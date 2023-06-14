package org.example;
import java.util.List;


public class ExamResultsPrinter {
    private int[] examGrades;
    private int studentId;

    public ExamResultsPrinter(int studentId,int[] examGrades) {
        this.examGrades = examGrades;
        this.studentId = studentId;
    }
    public void printResults() {
        System.out.printf("%9d | %10d | %7d | %3d\n",
            studentId, examGrades[0], examGrades[1], examGrades[2]);
        }
}

