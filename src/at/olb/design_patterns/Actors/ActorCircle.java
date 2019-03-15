package at.olb.design_patterns.Actors;

import at.olb.design_patterns.Interfaces.MoveStrategy;
import at.olb.design_patterns.Interfaces.Observer;
import org.newdawn.slick.Graphics;

public class ActorCircle extends AbstractActor implements Observer {
    private int radius;

    public ActorCircle(MoveStrategy ms, int radius){
        super(ms);
        this.radius = radius;
    }

    @Override
    public void move(int delta) {
        this.ms.update(delta);
    }

    @Override
    public void render(Graphics g) {
        g.drawOval(this.ms.getX(), this.ms.getY(), this.radius, this.radius);
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
        this.radius += 10;
    }

    public int getRadius() {
        return this.radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}
