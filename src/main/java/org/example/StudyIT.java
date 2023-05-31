package org.example;

public class StudyIT extends Study{
    @Override
    public void modifyStudent(Student student) {
        student.increaseSkill("IT");
    }
}
