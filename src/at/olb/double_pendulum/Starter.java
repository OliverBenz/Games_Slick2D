package at.olb.double_pendulum;

import at.olb.double_pendulum.Actors.Pendulum;
import org.newdawn.slick.*;

import static java.lang.StrictMath.cos;
import static java.lang.StrictMath.sin;


public class Starter extends BasicGame {


    // Fix LWJGL IntelliJ
    // ---------------------------------
    // http://wiki.lwjgl.org/wiki/Setting_Up_LWJGL_with_IntelliJ_IDEA.html
    // ---------------------------------

    // Constants
    private static int WIDTH = 1920;
    private static int HEIGHT = 1080;

    private static float originX = WIDTH / 2;
    private static float originY = HEIGHT / 4;

    private static float g = 9.81f;

    // Pendulums
    private Pendulum p1;
    private Pendulum p2;

    // ------------------------------------------------------------------------------------

    public Starter(String title) {
        super("Double Pendulum");
    }

    @Override
    public void init(GameContainer gc) throws SlickException {
        p1 = new Pendulum((float)(Math.PI),400,60, originX, originY);
        p2 = new Pendulum((float)(Math.PI / 4),300,90, p1.getX(), p1.getY());
    }

    // ------------------------------------------------------------------------------------

    @Override
    public void update(GameContainer gc, int delta) throws SlickException {
        // Time in seconds
        float time = (float)delta / 100;


        // Calculate Acceleration of Pendulum 1
        float num1 = -g * (2 * p1.getMass() + p2.getMass()) * (float)sin(p1.getAngle());
        float num2 = - p2.getMass() * g * (float)sin(p1.getAngle() - (2 * p2.getAngle()));
        float num3 = - 2 * (float)sin(p1.getAngle() - p2.getAngle()) * p2.getMass();
        float num4 = (p2.getVel() * p2.getVel()) * p2.getLength() + (p1.getVel() * p1.getVel()) * p1.getLength() * (float)cos(p1.getAngle() - p2.getAngle());
        float div1 = p1.getLength() * (2*p1.getMass() + p2.getMass() - p2.getMass() * (float)cos(2 * p1.getAngle() - 2 * p2.getAngle()));

        float acc1 = (num1 + num2 + num3 * num4) / div1;

        p1.setAcc(acc1);
        p1.move(originX, originY, time);


        // Calculate Acceleration of Pendulum 2
        float num5 = 2 * (float)sin(p1.getAngle() - p2.getAngle());
        float num6 = p1.getVel() * p1.getVel() * p1.getLength() * (p1.getMass() + p2.getMass());
        float num7 = g * (p1.getMass() + p2.getMass()) * (float)cos(p1.getAngle());
        float num8 = (p2.getVel() * p2.getVel()) * p2.getLength() * p2.getMass() * (float)cos(p1.getAngle() - p2.getAngle());
        float div2 = p2.getLength() * (2 * p1.getMass() + p2.getMass() - p2.getMass() * (float)cos(2 * p1.getAngle() - 2 * p2.getAngle()));

        float acc2 = (num5 * (num6 + num7 + num8)) / div2;

        p2.setAcc(acc2);
        p2.move(p1.getX(), p1.getY(), time);
    }

    // ------------------------------------------------------------------------------------

    @Override
    public void render(GameContainer gc, Graphics g) throws SlickException {
        g.drawLine(originX, originY, p1.getX(), p1.getY());
        p1.render(g);
        g.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
        p2.render(g);
    }

    // ------------------------------------------------------------------------------------

    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new Starter("Patterns"));
            container.setDisplayMode(WIDTH, HEIGHT,false);
            // container.setTargetFrameRate(60);
            container.start();

        } catch (SlickException e) {
            e.printStackTrace();
        }
    }


}
