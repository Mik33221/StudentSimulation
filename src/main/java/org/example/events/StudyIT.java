package org.example.events;

import org.example.Student;

public class StudyIT extends Study {    // dodaje punkty w informatyce i chęć na imprezę, zmniejsza pieniądze
    @Override
    public void modifyStudent(Student student) {
        student.increaseSkill("IT");
    }
}