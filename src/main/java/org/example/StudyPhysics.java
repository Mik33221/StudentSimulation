package org.example;

public class StudyPhysics extends Study{
    @Override
    public void modifyStudent(Student student) {
        student.increaseSkill("Physics");
    }
}
