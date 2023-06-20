package org.example;

/**
 * Intefejs osoby posiadającej okreslone predyspozycje
 */
public interface SkillGetter {
    /**
     * Pobiera poziom zadanej predyspozycji
     * @param skill - nazwa predyspozycji
     * @return - bieżący poziom predyspozycji
     */
    int getSkillValue(String skill);
}