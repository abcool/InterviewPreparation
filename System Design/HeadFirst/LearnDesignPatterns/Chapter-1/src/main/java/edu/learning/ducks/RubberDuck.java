package edu.learning.ducks;

import edu.learning.Duck;
import edu.learning.behaviour.fly.NoFly;
import edu.learning.behaviour.quack.Squeak;

public class RubberDuck extends Duck {

    public RubberDuck(){
        setQuackBehaviour(new Squeak());
        setFlyBehaviour(new NoFly());
    }

    @Override
    public void display() {
        System.out.println("Here is Rubber duck");
    }
}
