package edu.learning.ducks;

import edu.learning.Duck;
import edu.learning.behaviour.fly.FlyWithWings;
import edu.learning.behaviour.quack.Quack;

public class RedheadDuck extends Duck {

    public RedheadDuck(){
        quackBehaviour = new Quack();
        flyBehaviour = new FlyWithWings();
    }

    public void display(){
        System.out.println("Here's RedheadDuck");
    }
}
