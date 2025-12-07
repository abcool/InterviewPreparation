package edu.learning;

public class DuckSimulator {
    public static void main(String[] args) {
        System.out.println(" Starting duck similator ");
       var mallardDuck = new MallardDuck();
       var redheadDuck = new RedheadDuck();
       var rubberDuck = new RubberDuck();
       mallardDuck.display();
       mallardDuck.quack();
       mallardDuck.swim();
       mallardDuck.fly();
       redheadDuck.display();
       redheadDuck.swim();
       redheadDuck.quack();
       redheadDuck.fly();
       rubberDuck.display();
       rubberDuck.quack();
       rubberDuck.swim();
    }
}