package org.example;

public class Party implements Event{
    @Override
    public void modifyStudent(Student student) {
       // student.increaseHealth(10);
             int money=student.getPredisposition("Wealth")/2;
        student.setPredisposition("Wealth", money);

    }
}
