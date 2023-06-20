package org.example.events;

import org.example.Student;

/**
 * klasa abstrakcyjna, implementuje interfejs Event
 */
public abstract class Study implements Event {
    /**
     * @param student Przekazujemy obiekt studnent
     */
    @Override
    public void modifyStudent(Student student){}
}
