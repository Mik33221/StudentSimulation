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
    private boolean cancel = false;

    public SemesterWorker(int days, List<Student> studentList, Observer observer) {
        this.days = days;
        this.studentList = studentList;
        this.observers.add(observer);
    }

    @Override
    public void run() {
        while (!cancel) {
            outputStudentStateStatistics("Semester begins...");

            outputStudentStateStatistics("Students' live going on...");
            for (int i = 0; i < this.days; i++) {
                for (Student student : this.studentList) {
                    EventGenerator.generateRandomEvent(student).modifyStudent(student);
                }
                boolean tenDaysPassed = ((i+1) % 10 == 0);
                if (tenDaysPassed) {
                    outputStudentStateStatistics(String.format("Day %d passed...", i+1));
                }
            }

            outputStudentStateStatistics("Session started...");

            ExamSession examSession = new ExamSession(studentList);
            examSession.run();

//            outputStudentStateStatistics("Notes histogram...");
//        printNotesStatistics();

            outputStudentStateStatistics("Semester ended...");
            cancel();
        }
    }
    private void outputStudentStateStatistics(String title) {
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
        popMessage(3);
        console.push(title);
        console.push("|Active|NonActive|SuperHealthy|NonHealthy|");
        console.push(String.format("|%6d|%9d|%12d|%10d|", sumActive, sumNonActive, sumHealthOver70, sumHealthBelow20));

        flushToConsole();
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
        while(!this.console.empty() && count > 0) {
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

    void cancel() {
        cancel = true;
    }
}
