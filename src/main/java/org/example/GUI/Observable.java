package org.example.GUI;

public interface Observable {
    void addObserver(Observer observer);
    void notifyObservers(String message);
}
