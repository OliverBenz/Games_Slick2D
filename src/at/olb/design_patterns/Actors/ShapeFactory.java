package at.olb.design_patterns.Actors;

import at.olb.design_patterns.Interfaces.MoveStrategy;
import at.olb.design_patterns.Interfaces.Observer;
import org.newdawn.slick.Graphics;

public class ShapeFactory extends AbstractActor implements Observer {
    private int width, height, shape;
    // Shape: 0 - Oval; Rest - Rect

    public ShapeFactory(MoveStrategy ms, int width, int height, int shape){
        super(ms);
        this.width = width;
        this.height = height;
        this.shape = shape;
    }

    @Override
    public void move(int delta) {
        this.ms.update(delta);
    }

    @Override
    public void render(Graphics g) {
        if(this.shape == 0){
            g.drawOval(this.ms.getX(), this.ms.getY(), this.width, this.height);
        }
        else{
            g.drawRect(this.ms.getX(), this.ms.getY(), this.width, this.height);
        }
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
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getShape() {
        return shape;
    }

    public void setShape(int shape) {
        this.shape = shape;
    }
}
