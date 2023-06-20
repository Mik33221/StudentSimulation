package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Bazowa klasa opisująca i zmieniająca właściwości osoby
 * Dane osobowe, zdrowie, zasób pieniędzy i predyspozycje.
 * @implements SkillGetter
 *
 */
public class Person implements SkillGetter{
    /**
     * Imię
     */
    protected String name;
    /**
     * Nazwisko
     */
    protected String surName;
    /**
     * Poziom zdrowia
     */
    protected int health;
    /**
     * Poziom pieniędzy
     */
    protected int money;
    /**
     * Poziom predyspozycji do imprezowania
     */
    protected int social;
    /**
     * Mapa poziomów wiedzy z zakresu Matemetyki, Fizyki i IT
     */
    private final HashMap<String, Integer> skills = new HashMap<>();

    public Person(String name, String surName, int health, int money) {
        this.name = name;
        this.surName = surName;
        this.health = health;
        this.money = money;
        this.skills.put("Math",0);
        this.skills.put("Physics",0);
        this.skills.put("IT",0);
    }

    /**
     * Zwraca Imię osoby
     * @return name
     */
    public String getName() {
        return name;
    }
    /**
     * Zwraca Nazwisko osoby
     * @return surName
     */
    public String getSurName() {
        return surName;
    }
    /**
     * Zwraca poziom zdrowia
     * @return health
     */
    public int getHealth() {
        return health;
    }
    /**
     * Zwraca poziom pieniędzy
     * @return money
     */
    public int getMoney(){
        return money;
    }
    /**
     * Zwraca poziom chęci do imprezowania
     * @return social
     */
    public int getSocial(){
        return social;
    }

    /**
     * Zwiększa poziom zdrowia
     * @param value - ilosc punktów
     */
    public void increaseHealth(int value) {
        if (this.health + value <= 100) {
            this.health += value;
        } else {
            this.health = 100;
        }
    }
    /**
     * Zmniejsza poziom zdrowia
     * @param value - ilosc punktów
     */
    public void decreaseHealth(int value) {
        if (this.health - value >= 0) {
            this.health -= value;
        } else {
            this.health = 0;
        }
    }
    /**
     * Zwiększa poziom pieniędzy
     * @param value - ilosc punktów
     */
    public void increaseMoney(int value) {
        if (this.money + value <= 10000) {
            this.money += value;
        } else {
            this.money = 10000;
        }
    }
    /**
     * Zmniejsza poziom pieniędzy
     * @param value - ilosc punktów
     */
    public void decreaseMoney(int value) {
        if (this.money - value >= 0) {
            this.money -= value;
        } else {
            this.money = 0;
        }
    }
    /**
     * Zwiększa poziom chęci do imprez
     * @param value - ilosc punktów
     */
    public void increaseSocial(int value) {
        if (this.social + value <= 1000) {
            this.social += value;
        } else {
            this.social = 1000;
        }
    }
    /**
     * Zmniejsza poziom chęci do imprez
     * @param value - ilosc punktów
     */
    public void decreaseSocial(int value) {
        if (this.social - value >= 0) {
            this.social -= value;
        } else {
            this.social = 0;
        }
    }

    /**
     * Zwieksza poziom wiedzy z danego zakresu
     * @param skill - zakres wiedzy
     */
    public void increaseSkill(String skill){
        if (this.skills.get(skill)>30){
            this.skills.merge(skill, 1, (oldValue, newValue) -> oldValue + newValue);
        } else{
            this.skills.merge(skill, 2, (oldValue, newValue) -> oldValue + newValue);
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", health=" + health +
                '}';
    }

    @Override
    public int getSkillValue(String skill) {
        Integer value = this.skills.get(skill);
        return value != null ? value : 0;
    }

    public Set<String> getAllSkills() {
        return this.skills.keySet();
    }

    /**
     * Zwraca liste poziomów wiedzy w postaci łańcucha [wiedza=poziom..]
     * @return poziomy wiedzy w łańcuchu
     */
    public String getSkillsAsString() {
        StringBuilder stringBuffer = new StringBuilder();
        for (Map.Entry<String, Integer> entry : this.skills.entrySet()) {
            stringBuffer
                    .append("[Skill=").append(entry.getKey())
                    .append(", value=").append(entry.getValue()).append("],");
        }
        return stringBuffer.toString();
    }

    /**
     * Czy osoba jest mega zdrowa
     * @return true jesli tak, false gdy poziom zdrowia jest niższy
     */
    public boolean isSuperHealthy() {
        return getHealth() > 70;
    }
    /**
     * Czy osoba jest chora
     * @return true jesli tak, false gdy poziom zdrowia jest na wyższym poziomie
     */
    public boolean isNotHealthy() {
        return getHealth() <= 20;
    }
}