package org.example;

public class StudyPhysics extends Study{
    @Override
    public void modifyStudent(Student student) {
        int computerSkills = student.getStatistic("ComputerSkills");
        if (computerSkills > 30) {
            student.setStatistic("ComputerSkills", computerSkills + 2);
        } else {
            student.setStatistic("ComputerSkills", computerSkills + 1);
        }
    }
}
