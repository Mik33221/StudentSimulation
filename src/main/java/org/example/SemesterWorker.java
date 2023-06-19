package org.example;

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
            boolean tenDaysPassed = ((i + 1) % 10 == 0);
            if (tenDaysPassed) {
                outputStudentStateStatistics(String.format("Day %d passed...", i + 1));
            }
        }

        outputStudentStateStatistics("Session started...");

        ExamSession examSession = new ExamSession(studentList);
        examSession.run();

        outputStudentStateStatistics("Semester ended...");
        notifyOberversFinished();
    }

    private void outputStudentStateStatistics(String title) {
        int sumActive = 0;
        int sumNonActive = 0;
        int sumHealthOver70 = 0;
        int sumHealthBelow20 = 0;
        for (Student student : this.studentList) {
            if (student.getState() == StudentState.ACTIVE) {
                sumActive++;
            }
            if (student.getState() == StudentState.DELETED) {
                sumNonActive++;
            }
            if (student.getHealth() > 70) {
                sumHealthOver70++;
            }
            if (student.getHealth() <= 20) {
                sumHealthBelow20++;
            }
        }
        popMessage(2);
        pushMessage(title);
        pushMessage("|Active|NonActive|SuperHealthy|NonHealthy|");
        pushMessage(String.format("|%6d|%9d|%12d|%10d|", sumActive, sumNonActive, sumHealthOver70, sumHealthBelow20));

        flushToConsole();
    }

    private String pushMessage(String title) {
        return console.push(title);
    }

    private void flushToConsole() {
        String messages = String.join("\n", this.console);
        notifyObservers(messages);
        try {
            TimeUnit.MILLISECONDS.sleep(1000); //pause
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

}
