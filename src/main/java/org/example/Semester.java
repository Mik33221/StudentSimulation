package org.example;

import org.example.events.EventGenerator;

import java.util.List;

public class Semester {
    final int days;
    final List<Student> studentList;


    public Semester(int days, List<Student> studentList) {
        this.days = days;
        this.studentList = studentList;
    }

    public void run() {
        System.out.println("\n\nSemester begins...");
        this.printStudentStateStatistics();

        System.out.println("\n\nStudents' live going on...");
        for (int i = 0; i < this.days; i++) {
            for (Student student : this.studentList) {
                EventGenerator.generateRandomEvent(student).modifyStudent(student);
            }
            if ((i+1) % 10 == 0) {
                System.out.println("\n\nNext 10 days passed...");
                this.printStudentStateStatistics();
            }
        }

        System.out.println("\n\nSession started...");
        this.printStudentStateStatistics();

        //SkillGetter skillGetter = new SkillGetter();

        System.out.println("\n\nExams");
        System.out.println("\n\n--------------EGZAMINY--------------");
             System.out.println("studentId | Matematyka | Fizyka | IT");
        System.out.println("-------------------------------------");
        for (Student student : this.studentList) {
            Exam exam = new Exam(student.getSkillValue("Math"),student.getSkillValue("Physics"),student.getSkillValue("IT"));

            exam.modifyStudent(student);
            System.out.println("-------------------------------------");
        }

      /*  System.out.println("\n\nExam Results");
        ExamResultsPrinter resultsPrinter =
                new ExamResultsPrinter(studentList);
        resultsPrinter.displayExamResultsTable();
*/


        System.out.println("\n\nNotes histogram...");
        printNotesStatistics();

        System.out.println("\n\nSemester ended...");
        this.printStudentStateStatistics();
    }
    private void printNotesStatistics() {
        int[] histogram = {0, 0, 0, 0};
        for (Student student : this.studentList) {
            for (String skill: student.getAllSkills()) {
                histogram[calculateNote(student.getSkillValue(skill))-2]++;
            }
        }
        if (this.studentList.size() > 0) {
            for (int i = 0; i < histogram.length; i++) {
                printHistogramBar(i + 2, histogram[i] * 100 / this.studentList.size() );
            }
        }
    }

    private void printHistogramBar(int note, int height) {
        System.out.printf("Note: %d - ", note);
        for (int i = 0; i < height; i++) {
            System.out.print('#');
        }
        System.out.printf(" -(%d)\n", height);
    }

    private int calculateNote(int points) {
        if (points >= 50) {
            return 5;
        } else if (points >= 40) {
            return 4;
        } else if (points >= 30) {
            return 3;
        } else {
            return 2;
        }
    }

    private void printStudentStateStatistics() {
        int sumActive = 0;
        int sumNonActive = 0;
        int sumHealthOver70 = 0;
        int sumHealthBelow20 = 0;
        for (Student student : this.studentList) {
            if (student.state == StudentState.ACTIVE) { sumActive++; }
            if (student.state == StudentState.DELETED) { sumNonActive++; }
            if (student.getHealth() > 70) { sumHealthOver70++; }
            if (student.getHealth() <= 20) { sumHealthBelow20++; }
        }
//        System.out.println("Students' population statisticts:");
        System.out.printf("|Active|NonActive|SuperHealthy|NonHealthy|\n");
        System.out.printf("|%6d|%9d|%12d|%10d|\n", sumActive, sumNonActive, sumHealthOver70, sumHealthBelow20);

    }
}
