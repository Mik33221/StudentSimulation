package org.example.events;

import org.example.Student;

import java.util.Random;

public class Party implements Event {   //przywraca chęć na imprezę do początkowej wartości, zabiera częśc pieniędzy
    @Override
    public void modifyStudent(Student student) {
        student.resetSocial();
        student.decreaseMoney(student.getMoney()/new Random().nextInt(10,60));
    }
}
