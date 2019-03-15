package at.olb.design_patterns;

import at.olb.design_patterns.Actors.ShapeFactory;
import at.olb.design_patterns.Actors.SingletonMoveChange;
import at.olb.design_patterns.Interfaces.Actor;
import at.olb.design_patterns.Interfaces.MoveStrategy;
import at.olb.design_patterns.Interfaces.Observable;
import at.olb.design_patterns.Interfaces.Observer;
import at.olb.design_patterns.Strategies.MoveDown;
import at.olb.design_patterns.Strategies.MoveLeft;
import at.olb.design_patterns.Strategies.MoveRight;
import at.olb.design_patterns.Strategies.MoveUp;
import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.List;

public class Starter extends BasicGame implements Observable {

    // Constants
    private static int WIDTH = 1920;
    private static int HEIGHT = 1080;

    private List<Actor> actors;
    private List<Observer> observers;

    private int countOval;
    private int countRect;

    public Starter(String title) {
        super("DesignPatterns");
    }

    @Override
    public void init(GameContainer container) throws SlickException {
        this.actors = new ArrayList<Actor>();
        this.observers = new ArrayList<Observer>();

        this.countOval = 2;
        this.countRect = 2;

        this.generateActor(countOval, 0, new MoveDown(this.WIDTH / 2, this.HEIGHT / 2));
        this.generateActor(countRect, 1, new MoveLeft(this.WIDTH / 2, this.HEIGHT / 2));
    }

    @Override
    public void update(GameContainer gc, int delta) throws SlickException {
        for(Actor a: actors){
            this.moveResponse(a);
            a.move(delta);
        }
    }

    @Override
    public void render(GameContainer gc, Graphics g) throws SlickException {
        for(Actor a: actors){
            a.render(g);
        }
    }

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

    public void generateActor(int count, int type, MoveStrategy ms){
        for(int i = 0; i < count; i++){
            ShapeFactory sf = new ShapeFactory(ms, 30,30,type);
            this.actors.add(sf);
            this.addObserver(sf);
        }
    }

    public void moveResponse(Actor a){
        int x = a.getMoveStrategy().getX();
        int y = a.getMoveStrategy().getY();

        if(x <= 0){
            a.setMoveStrategy(new MoveRight(x, y));
            this.singletonChange(1);
        }
        else if(x >= this.WIDTH){
            a.setMoveStrategy(new MoveLeft(x, y));
            this.singletonChange(1);
        }
        else if(y <= 0){
            a.setMoveStrategy(new MoveDown(x, y));
            this.singletonChange(1);
        }
        else if(y > this.HEIGHT){
            a.setMoveStrategy(new MoveUp(x, y));
            this.singletonChange(1);
        }
    }

    public void singletonChange(int val){
        if(val > 0){
            SingletonMoveChange.getInstance().addChange();
        }
        else{
            SingletonMoveChange.getInstance().subChange();
        }

        System.out.println(SingletonMoveChange.getInstance().getChange());
        if(SingletonMoveChange.getInstance().getChange() % 10 == 0){
            this.informAll();
        }
    }

    @Override
    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void informAll() {
        for(Observer o: observers){
            o.inform();
        }
    }
}
