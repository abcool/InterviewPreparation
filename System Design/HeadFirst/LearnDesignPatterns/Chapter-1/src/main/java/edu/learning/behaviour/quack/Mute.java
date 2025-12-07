package edu.learning.behaviour.quack;

import edu.learning.QuackBehaviour;

public class Mute implements QuackBehaviour {
    @Override
    public void quack() {
        System.out.println("Duck can't quack");
    }
}
