package edu.learning.ducks;

import edu.learning.Duck;
import edu.learning.behaviour.fly.FlyWithWings;
import edu.learning.behaviour.quack.Quack;

public class MallardDuck extends Duck {

    public MallardDuck(){
        setFlyBehaviour(new FlyWithWings());
        setQuackBehaviour(new Quack());
    }

    @Override
    public void display() {
        System.out.println("Here's MallardDuck!");
    }
}
