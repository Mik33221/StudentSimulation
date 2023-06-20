package org.example.GUI;

import org.example.Exam;
import org.example.ExamSession;
import org.example.SemesterLogger;
import org.example.Student;
import org.example.events.EventGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.TimeUnit;

public class SemesterWorker implements Runnable, Observable {
    final int days;
    final List<Student> studentList;
    private Stack<String> console = new Stack<>();

    private List<Observer> observers = new ArrayList<>();

    public SemesterWorker(int days, List<Student> studentList) {
        this.days = days;
        this.studentList = studentList;
    }

    @Override
    public void run() {
        outputStudentStateStatistics("Semester begins...");

        outputStudentStateStatistics("Students' live going on...");
        for (int i = 0; i < this.days; i++) {
            for (Student student : this.studentList) {
                EventGenerator.generateRandomEvent(student).modifyStudent(student);
            }

            popMessage(25);
            for (Student student : this.studentList) {
                outputStudentStatistic(student);
            }
            flushToConsole();

            /*
            boolean tenDaysPassed = ((i + 1) % 10 == 0);
            if (tenDaysPassed) {
                outputStudentStateStatistics(String.format("Day %d passed...", i + 1));
            }*/
        }
        popMessage(27);
        pushMessage("Session started...");
        flushToConsole();

        ExamSession examSession = new ExamSession(studentList);
        examSession.run();
        runExams();

        pushMessage("Semester ended");
        flushToConsole();

        notifyOberversFinished();
    }
    public void outputStudentStatistic(Student student){
        pushMessage(student.getName()+" "+student.getSurName()+" "+student.getIndexNumber()+" \thealth: "+student.getHealth()+" \tmoney: "+student.getMoney());
        pushMessage("Math    : "+drawSkill(student.getSkillValue("Math")));
        pushMessage("Physics : "+drawSkill(student.getSkillValue("Physics")));
        pushMessage("IT      : "+drawSkill(student.getSkillValue("IT")));
        pushMessage("");
    }
    public static String drawSkill(int skill){
        String a = "";
        for (int i = 0; i < skill; i++) {
            a += "#";
        }
        return a;
    }

    private void outputStudentStateStatistics(String title) {
        int sumActive = 0;
        int sumNonActive = 0;
        int sumSuperHealthy = 0;
        int sumNotHealthy = 0;
        for (Student student : this.studentList) {
            if (student.isActive()) { sumActive++; }
            if (student.isNotActive()) { sumNonActive++; }
            if (student.isSuperHealthy()) { sumSuperHealthy++; }
            if (student.isNotHealthy()) { sumNotHealthy++; }
        }
        popMessage(3);
        pushMessage(title);
        pushMessage("|Active|NonActive|SuperHealthy|NonHealthy|");
        pushMessage(String.format("|%6d|%9d|%12d|%10d|", sumActive, sumNonActive, sumSuperHealthy, sumNotHealthy));

        flushToConsole();
    }

    private String pushMessage(String title) {
        return console.push(title);
    }

    private void flushToConsole() {
        String messages = String.join("\n", this.console);
        notifyObservers(messages);
        try {
            TimeUnit.MILLISECONDS.sleep(200); //pause
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    private void popMessage(int count) {
        while (!this.console.empty() && count > 0) {
            this.console.pop();
            count--;
        }
    }

    @Override
    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void notifyObservers(String message) {
        this.observers.forEach(observer -> observer.update(message));
    }

    public void notifyOberversFinished() {
        this.observers.forEach(observer -> observer.finished());
    }
    public void runExams(){
        pushMessage("\n--------------EGZAMINY--------------");
        pushMessage("studentId | Matematyka | Fizyka | IT");
        pushMessage("-------------------------------------");
        for (Student student : this.studentList) {
            Exam exam = new Exam(student.getSkillValue("Math"),student.getSkillValue("Physics"),student.getSkillValue("IT"));
            exam.modifyStudent(student);
            pushMessage(String.format("%9d | %10d | %7d | %3d", student.getIndexNumber(), student.getExamGrades()[0],student.getExamGrades()[1],student.getExamGrades()[2]));
            pushMessage("-------------------------------------");
        }

    }

}