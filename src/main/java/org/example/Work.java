package org.example;

public class Work implements Event{
    @Override
    public void modifyStudent(Student student) {
        student.decreaseHealth(10);
    }
}
