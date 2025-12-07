package edu.learning;

public class RubberDuck extends Duck{
    @Override
    public void display() {
        System.out.println("Here is Rubber duck");
    }

    @Override
    public void quack() {
        System.out.println("Rubber duck squeeks.");
    }

    @Override
    public void fly() {
        // disabled flying
    }
}
