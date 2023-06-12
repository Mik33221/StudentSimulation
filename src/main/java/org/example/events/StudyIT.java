package org.example.events;

import org.example.Student;

public class StudyIT extends Study {
    @Override
    public void modifyStudent(Student student) {
        student.increaseSkill("IT");
    }
}
