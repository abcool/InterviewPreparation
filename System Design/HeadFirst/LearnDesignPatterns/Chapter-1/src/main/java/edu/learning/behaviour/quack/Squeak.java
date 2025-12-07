package edu.learning.behaviour.quack;

import edu.learning.QuackBehaviour;

public class Squeak implements QuackBehaviour {
    @Override
    public void quack() {
        System.out.println("Duck makes squeak sounds");
    }
}
