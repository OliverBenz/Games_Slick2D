package at.olb.design_patterns.Interfaces;

public interface Observable {
    void addObserver(Observer observer);
    void informAll();
}
