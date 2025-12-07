package edu.learning.behaviour.fly;

import edu.learning.FlyBehaviour;

public class FlyWithRocket implements FlyBehaviour {
    @Override
    public void fly() {
        System.out.println("Duck flies using rocket boosters.");
    }
}
