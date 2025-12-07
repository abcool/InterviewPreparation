package edu.learning.ducks;

import edu.learning.Duck;
import edu.learning.behaviour.fly.FlyWithRocket;
import edu.learning.behaviour.quack.Mute;

public class WoodenDuck extends Duck {

    public WoodenDuck(){
        quackBehaviour = new Mute();
        flyBehaviour = new FlyWithRocket();
    }

    @Override
    public void display() {
        System.out.println("This is a wooden duck");
    }
}
