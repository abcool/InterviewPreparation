package edu.learning.behaviour.fly;

import edu.learning.FlyBehaviour;

public class NoFly implements FlyBehaviour {
    @Override
    public void fly() {
        System.out.println("Duck can't fly");
    }
}
