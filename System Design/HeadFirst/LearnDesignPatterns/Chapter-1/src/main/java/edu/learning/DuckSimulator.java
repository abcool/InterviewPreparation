package edu.learning;

public class DuckSimulator {
    public static void main(String[] args) {
        System.out.println(" Starting duck similator ");
       MallardDuck mallardDuck = new MallardDuck();
       RedheadDuck redheadDuck = new RedheadDuck();
       mallardDuck.display();
       mallardDuck.quack();
       mallardDuck.swim();
       mallardDuck.fly();
       redheadDuck.display();
       redheadDuck.swim();
       redheadDuck.quack();
       redheadDuck.fly();
    }
}