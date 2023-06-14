package org.example;

import org.example.events.Event;


public class Exam implements Event {
    final private int mathSkillValue;
    final private int physicsSkillValue;
    final private int itSkillValue;

    public Exam(int mathSkillValue, int physicsSkillValue, int itSkillValue) {
        this.mathSkillValue = mathSkillValue;
        this.physicsSkillValue = physicsSkillValue;
        this.itSkillValue = itSkillValue;
    }

    @Override
    public void modifyStudent(Student student) {
        int[] examGrades = new int[3];
        //int numFailedExams = 0; Zmienna nie używana nigdzie, proponuje wprowadzić tą funkcjonalność zliczając dwóje studentów

        if (student.getHealth() > 10) {
            examGrades[0] = calGrade(mathSkillValue);
            examGrades[1] = calGrade(physicsSkillValue);
            examGrades[2] = calGrade(itSkillValue);
        }

        student.setExamGrades(examGrades);
    }

    private int calGrade(int points) {
        if (points >= 50) {
            return 5;
        } else if (points >= 40) {
            return 4;
        } else if (points >= 30) {
            return 3;
        } else {
            return 2;
        }
    }
}