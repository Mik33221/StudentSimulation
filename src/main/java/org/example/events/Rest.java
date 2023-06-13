package org.example.events;
import org.example.Student;

import java.util.Random;

public class Rest implements Event {    // odpoczynek odnawia 20-60 zdrowia
    @Override
    public void modifyStudent(Student student) {
        student.increaseHealth(new Random().nextInt(20,60));
    }
}