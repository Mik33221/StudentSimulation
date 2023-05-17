package org.example;

public class Work implements Event{
    @Override
    public void ModifyStudent(Student student) {
        student.setHealth(-10);
    }
}
