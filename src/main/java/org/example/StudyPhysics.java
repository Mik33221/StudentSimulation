package org.example;

public class StudyPhysics extends Study{
    @Override
    public void ModifyStudent(Student student) {
        student.getSkills().merge("Physics",1,(oldValue, newValue) -> (int)oldValue + (int)newValue);
    }
}
