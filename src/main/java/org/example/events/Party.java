package org.example.events;

import org.example.Student;

import java.util.Random;
/**
 * klasa implementująca interfejs Event, zmniejsza parametry studenta w zakesie money, health, social
 */
public class Party implements Event {   //przywraca chęć na imprezę do początkowej wartości, zabiera częśc pieniędzy
    @Override
    public void modifyStudent(Student student) {
        student.resetSocial();
        student.decreaseMoney(student.getMoney()/new Random().nextInt(10,60));
    }
}
