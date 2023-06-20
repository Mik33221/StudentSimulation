package org.example;
/**
*Interfejs, po którym dziedziczy klasa Person,
*Pozwala on na dostęp do wartości umiejętności
*studneta z danej dziedziny Zawiera metodę getSkillValue,
*która nie posiada ciała, lecz jest nadpisywana w inncych klasach.
 */
public interface SkillGetter{
    int getSkillValue(String skill);
}