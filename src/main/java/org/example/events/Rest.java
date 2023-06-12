package org.example.events;
import org.example.Student;

import java.util.Random;

public class Rest implements Event {
    @Override
    public void modifyStudent(Student student) {
        student.increaseHealth(new Random().nextInt(40)+20);
    }
}