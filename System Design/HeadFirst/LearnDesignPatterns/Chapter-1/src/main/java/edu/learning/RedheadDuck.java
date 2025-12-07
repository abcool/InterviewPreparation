package edu.learning;

public class RedheadDuck extends Duck implements Flyable, Quackable{
    public void display(){
        System.out.println("Here's RedheadDuck");
    }

    @Override
    public void fly() {
        System.out.println("RedheadDuck flys");
    }

    @Override
    public void quack() {
        System.out.println("RedheadDuck quacks");
    }
}
