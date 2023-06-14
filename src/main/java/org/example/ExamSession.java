package org.example;

import java.util.List;


public class ExamSession {
    final List<Student> studentList;

    public ExamSession(List<Student> studentList) {
        this.studentList = studentList;
    }
    public void run(){

        System.out.println("\n\n--------------EGZAMINY--------------");
        System.out.println("studentId | Matematyka | Fizyka | IT");
        System.out.println("-------------------------------------");
        for (Student student : this.studentList) {
            Exam exam = new Exam(student.getSkillValue("Math"),student.getSkillValue("Physics"),student.getSkillValue("IT"));
            exam.modifyStudent(student);
            printResults(student);
        }

    }
    public void printResults(Student student) {
        System.out.printf("%9d | %10d | %7d | %3d\n",
            student.indexNumber, student.getExamGrades()[0],student.getExamGrades()[1],student.getExamGrades()[2]);
        System.out.println("-------------------------------------");
        }
}

