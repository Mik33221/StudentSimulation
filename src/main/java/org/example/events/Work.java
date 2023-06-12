package org.example.events;

import org.example.Student;

public class Work implements Event {
    @Override
    public void modifyStudent(Student student) {
        student.decreaseHealth(10);
        int money= student.getPredisposition("Wealth")+100;
        student.setPredisposition("Wealth", money);
    }
}
