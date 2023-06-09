package org.example;

public class Party implements Event{
    @Override
    public void modifyStudent(Student student) {
        int socializationDesire = student.getStatistic("SocializationDesire");
        if (socializationDesire > 50) {
            student.attendParty();
        }
    }
}
