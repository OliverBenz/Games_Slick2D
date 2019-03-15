package at.olb.pi;

import org.newdawn.slick.*;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Starter extends BasicGame{

    public Starter(String title) {
        super("Double Pendulum");
    }

    // Constants
    private static int WIDTH = 1920;
    private static int HEIGHT = 1080;

    private static float orientX = WIDTH / 2;
    private static float orientY = HEIGHT / 2;

    private float diameter = 800;

    private double biggest = 1;
    private int inCircle = 0;
    private int total = 0;

    private int x;
    private int y;

    @Override
    public void init(GameContainer gc) throws SlickException {
        this.x = 0;
        this.y = 0;
    }

    @Override
    public void update(GameContainer gc, int delta) throws SlickException {
        // Math.random ---------- (Math.random() * range) + min;
        this.x = (int)((Math.random() * diameter) + (WIDTH / 2 - (diameter / 2)));
        this.y = (int)((Math.random() * diameter) + (HEIGHT / 2) - (diameter / 2));

        double distance = sqrt(pow(x - orientX, 2) + pow(y - orientY, 2));

        if(distance < diameter / 2){
            inCircle++;
        }
        total++;

        double pi = (double)4 * ((double)inCircle / (double)total);

        if(Math.abs(Math.PI - pi) < Math.abs(Math.PI - this.biggest)){
            this.biggest = pi;
            System.out.println(pi);
        }
    }

    @Override
    public void render(GameContainer gc, Graphics g) throws SlickException {
        g.drawOval(WIDTH / 2 - diameter / 2, HEIGHT / 2 - diameter / 2, diameter, diameter);
        g.drawRect(WIDTH / 2 - diameter / 2, HEIGHT / 2 - diameter / 2, diameter, diameter);

        g.fillOval(this.x, this.y,10,10);
    }

    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new Starter("Patterns"));
            container.setDisplayMode(WIDTH, HEIGHT,false);
            // container.setTargetFrameRate(1);
            container.start();

        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
