package edu.learning;

public class MallardDuck extends Duck implements Flyable,Quackable{

    @Override
    public void display() {
        System.out.println("Here's MallardDuck!");
    }

    @Override
    public void fly() {
        System.out.println("MallardDuck flys");
    }

    @Override
    public void quack() {
        System.out.println("MallardDuck quacks");
    }
}
