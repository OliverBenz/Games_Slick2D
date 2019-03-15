package at.olb.design_patterns.Interfaces;

import org.newdawn.slick.Graphics;

public interface Actor {
    void move(int delta);
    void render(Graphics g);
    void setMoveStrategy(MoveStrategy ms);
    MoveStrategy getMoveStrategy();
}
