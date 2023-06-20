package org.example;

import java.util.List;


/**
 * Kontroluje przebieg sesji egzaminacyjnej
 */
public class ExamSession {
    final List<Student> studentList;

    public ExamSession(List<Student> studentList) {
        this.studentList = studentList;
    }
    public void run(){
        printAndSave("\n\n--------------EGZAMINY--------------\n");
        printAndSave("studentId | Matematyka | Fizyka | IT\n");
        printAndSave("-------------------------------------\n");
        for (Student student : this.studentList) {
            Exam exam = new Exam(student.getSkillValue("Math"),student.getSkillValue("Physics"),student.getSkillValue("IT"));
            exam.modifyStudent(student);
            printAndSave(String.format("%9d | %10d | %7d | %3d\n", student.indexNumber, student.getExamGrades()[0],student.getExamGrades()[1],student.getExamGrades()[2]));
            printAndSave("-------------------------------------\n");
        }

    }

    private void printAndSave(String text) {
        System.out.print(text);
        SemesterLogger.log(text);
    }
}

