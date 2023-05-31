package org.example;

public class Party implements Event{
    @Override
    public void modifyStudent(Student student) {
        student.increaseHealth(10);
    }
}
