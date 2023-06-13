package org.example.events;

import org.example.Student;

public class StudyPhysics extends Study {   // dodaje punkty w fizyce i chęć na imprezę, zmniejsza pieniądze
    @Override
    public void modifyStudent(Student student) {
        student.increaseSkill("Physics");
    }
}
