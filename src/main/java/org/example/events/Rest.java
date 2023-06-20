package org.example.events;
import org.example.Student;

import java.util.Random;
/**
 * klasa implementująca interfejs Event, zwiększa parametry studenta w zakesie health
 */
public class Rest implements Event {    // odpoczynek odnawia 20-60 zdrowia
    @Override
    public void modifyStudent(Student student) {
        student.increaseHealth(new Random().nextInt(20,60));
    }
}