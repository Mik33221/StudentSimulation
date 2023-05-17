package org.example;

public class Party implements Event{
    @Override
    public void ModifyStudent(Student student) {
        student.setHealth(10);
    }
}
