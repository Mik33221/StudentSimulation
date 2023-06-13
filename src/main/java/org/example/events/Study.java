package org.example.events;

import org.example.Student;

public abstract class Study implements Event {
    @Override
    public void modifyStudent(Student student){}
}
