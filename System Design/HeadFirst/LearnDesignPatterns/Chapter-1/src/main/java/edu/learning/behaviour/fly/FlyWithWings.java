package edu.learning.behaviour.fly;

import edu.learning.FlyBehaviour;

public class FlyWithWings implements FlyBehaviour {
    @Override
    public void fly() {
        System.out.println("Duck is flying");
    }
}
