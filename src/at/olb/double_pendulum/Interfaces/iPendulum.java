package at.olb.double_pendulum.Interfaces;

import org.newdawn.slick.Graphics;

public interface iPendulum {
    void move(float oX, float oY, float time);
    void render(Graphics g);
}
