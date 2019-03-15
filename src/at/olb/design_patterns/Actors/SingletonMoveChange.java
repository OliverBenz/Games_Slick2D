package at.olb.design_patterns.Actors;

public class SingletonMoveChange {
    private static SingletonMoveChange ourInstance = new SingletonMoveChange();

    private int counter;

    public static SingletonMoveChange getInstance() {
        return ourInstance;
    }

    private SingletonMoveChange() {
        this.counter = 0;
    }

    public void addChange(){
        this.counter++;
    }

    public void subChange(){
        this.counter--;
    }

    public int getChange(){
        return this.counter;
    }
}
