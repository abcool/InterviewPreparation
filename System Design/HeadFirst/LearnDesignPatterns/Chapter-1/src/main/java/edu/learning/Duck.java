package edu.learning;

public class Duck {
    public void quack(){
        System.out.println("Duck quacks");
    }
    public void swim(){
        System.out.println("Duck swims");
    }
    public void display(){}
    // On adding fly behaviour here, all child classes inherit this which is not required.
    // Only select child classes should inherit.
    public void fly(){
        System.out.println("Duck flys");
    }
}
