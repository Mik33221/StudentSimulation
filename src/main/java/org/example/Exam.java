package org.example;

import org.example.events.Event;

/**
 *   Klasa do której przekazywane są wartości umiejętności z każdego ze studiowanych przedmiotów.
 */
public class Exam implements Event {

    private int mathSkillValue;
    private int physicsSkillValue;
    private int itSkillValue;

    public Exam(int mathSkillValue, int physicsSkillValue, int itSkillValue) {
        /**
         * umiejętności matematyczne
         */
        this.mathSkillValue = mathSkillValue;
        /**
         * umiejętności z fizyki
         */
        this.physicsSkillValue = physicsSkillValue;
        /**
         * umiejętności IT
         */
        this.itSkillValue = itSkillValue;
    }

    @Override
    /**
     * Wypełnia tablicę ocen studenta Ocenami z egzaminów
     */
    public void modifyStudent(Student student) {
        int[] examGrades = new int[3];
        int numFailedExams = 0;

        if (student.getHealth() > 10) {
            if (mathSkillValue >= 30) {
                int grade = calGrade(mathSkillValue);
                examGrades[0] = grade;
            } else {
                examGrades[0] = 2;
                numFailedExams++;
            }

            if (physicsSkillValue >= 30) {
                int grade = calGrade(physicsSkillValue);
                examGrades[1] = grade;
            } else {
                examGrades[1] = 2;
                numFailedExams++;
            }


            if (itSkillValue >= 30) {
                int grade = calGrade(itSkillValue);
                examGrades[2] = grade;
            } else {
                examGrades[2] = 2;
                numFailedExams++;
            }
        }

        student.setExamGrades(examGrades);
        ExamResultsPrinter resultsPrinter = new ExamResultsPrinter(student.indexNumber, examGrades);
        resultsPrinter.printResults();

    }


    /**
     *
     * @param points wartosc punktów z egzaminu
     * @return ocena z poszczególnego egzaminu
     */
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