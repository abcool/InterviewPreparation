package edu.learning.behaviour.quack;

import edu.learning.QuackBehaviour;

public class Quack implements QuackBehaviour {
    @Override
    public void quack() {
        System.out.println("Duck quacks");
    }
}
