package at.olb.design_patterns.Strategies;

import at.olb.design_patterns.Interfaces.MoveStrategy;

public class MoveDown implements MoveStrategy {
    private int x, y;

    public MoveDown(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public void update(int delta) {
        this.y += delta;
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
