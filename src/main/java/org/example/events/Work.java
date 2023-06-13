package org.example.events;

import org.example.Student;

import java.util.Random;

public class Work implements Event {    // dodaje pieniądze i chęć na imprezę, zabiera życie
    @Override
    public void modifyStudent(Student student) {
        student.increaseMoney(new Random().nextInt(300,600));
        student.increaseSocial(new Random().nextInt(2,10));
        student.decreaseHealth(new Random().nextInt(5,15));
    }
}
