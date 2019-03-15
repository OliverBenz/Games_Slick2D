package at.olb.design_patterns.Interfaces;

public interface MoveStrategy {
    void update(int delta);

    int getX();
    int getY();

    void setX(int x);
    void setY(int y);
}
