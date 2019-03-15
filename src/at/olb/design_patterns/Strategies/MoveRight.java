package at.olb.design_patterns.Strategies;

import at.olb.design_patterns.Interfaces.MoveStrategy;

public class MoveRight implements MoveStrategy {
    int x, y;

    public MoveRight(int x, int y){
        this.x = x;
        this.y = y;
    }


    @Override
    public void update(int delta) {
        this.x += delta;
    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }
}
