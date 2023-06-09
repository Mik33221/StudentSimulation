package org.example;

public class StudyMath extends Study{
    @Override
    public void modifyStudent(Student student) {
        int physicalSkills = student.getStatistic("PhysicalSkills");
        if (physicalSkills > 30) {
            student.setStatistic("PhysicalSkills", physicalSkills + 2);
        } else {
            student.setStatistic("PhysicalSkills", physicalSkills + 1);
        }
    }
}
