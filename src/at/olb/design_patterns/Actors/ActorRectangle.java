package at.olb.design_patterns.Actors;

import at.olb.design_patterns.Interfaces.MoveStrategy;
import at.olb.design_patterns.Interfaces.Observer;
import org.newdawn.slick.Graphics;

public class ActorRectangle extends AbstractActor implements Observer {
    private int width, height;

    public ActorRectangle(MoveStrategy ms, int width, int height){
        super(ms);
        this.width = width;
        this.height = height;
    }

    @Override
    public void move(int delta) {
        this.ms.update(delta);
    }

    @Override
    public void render(Graphics g) {
        g.drawRect(this.ms.getX(), this.ms.getY(), this.width, this.height);
    }

    @Override
    public void setMoveStrategy(MoveStrategy ms) {
        this.ms = ms;
    }

    @Override
    public MoveStrategy getMoveStrategy() {
        return this.ms;
    }

    @Override
    public void inform() {
        this.width += 10;
        this.height += 10;
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
