package org.example;

public class Rest implements Event{
    @Override
    public void modifyStudent(Student student) {
        student.increaseHealth(10);
    }
}