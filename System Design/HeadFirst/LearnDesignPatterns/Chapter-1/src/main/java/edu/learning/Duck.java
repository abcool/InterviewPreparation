package edu.learning;

public abstract class Duck {

    public QuackBehaviour quackBehaviour;
    public FlyBehaviour flyBehaviour;

    public Duck(){}

    public void swim(){
        System.out.println("Duck swims");
    }
    public abstract void display();

    public void performFly(){
        flyBehaviour.fly();
    }

    public void performQuack(){
        quackBehaviour.quack();
    }

}
