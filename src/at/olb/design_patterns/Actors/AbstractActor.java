package at.olb.design_patterns.Actors;

import at.olb.design_patterns.Interfaces.Actor;
import at.olb.design_patterns.Interfaces.MoveStrategy;

public abstract class AbstractActor implements Actor {
    protected MoveStrategy ms;

    public AbstractActor(MoveStrategy ms){
        this.ms = ms;
    }
}
