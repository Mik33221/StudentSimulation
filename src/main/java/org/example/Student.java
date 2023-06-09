package org.example;
import java.util.HashMap;
import java.util.Map;

public class Student extends Person{
    final int indexNumber;
    private Map<String, Integer> statistics;
    /*private int mathSkills;
    private int physicalSkills;
    private int computerSkills;
    private int socializationDesire;
*/

    public Student(String name, String surName, int health,int indexNumber, int mathSkills, int physicalSkills, int computerSkills, int socializationDesire) {
        super(name,surName,health);
        this.indexNumber = indexNumber;
        statistics = new HashMap<>();
        statistics.put("MathSkills", mathSkills);
        statistics.put("PhysicalSkills", physicalSkills);
        statistics.put("ComputerSkills", computerSkills);
        statistics.put("SocializationDesire", socializationDesire);
        /*this.mathSkills = mathSkills;
        this.physicalSkills = physicalSkills;
        this.computerSkills = computerSkills;
        this.socializationDesire = socializationDesire;*/

    }

    public void setStatistic(String name, int value) {
        statistics.put(name, value);
    }

    public int getStatistic(String name) {
        return statistics.getOrDefault(name, 0);
    }



    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", health=" + health +
                ", indexNumber=" + indexNumber +
                ", mathSkills=" + statistics.getOrDefault("MathSkills", 0) +
                ", physicalSkills=" + statistics.getOrDefault("PhysicalSkills", 0) +
                ", computerSkills=" + statistics.getOrDefault("ComputerSkills", 0) +
                ", socializationDesire=" + statistics.getOrDefault("SocializationDesire", 0) +
                '}';
    }
}
