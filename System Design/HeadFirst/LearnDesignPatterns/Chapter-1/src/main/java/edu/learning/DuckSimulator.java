package edu.learning;

import edu.learning.ducks.MallardDuck;
import edu.learning.ducks.RedheadDuck;
import edu.learning.ducks.RubberDuck;
import edu.learning.ducks.WoodenDuck;

public class DuckSimulator {
    public static void main(String[] args) {
        System.out.println(" Starting duck similator ");
       var mallardDuck = new MallardDuck();
       var redheadDuck = new RedheadDuck();
       var rubberDuck = new RubberDuck();
       var woodenDuck = new WoodenDuck();
       mallardDuck.display();
       mallardDuck.performQuack();
       mallardDuck.swim();
       mallardDuck.performFly();
       redheadDuck.display();
       redheadDuck.swim();
       redheadDuck.performQuack();
       redheadDuck.performFly();
       rubberDuck.display();
       rubberDuck.performQuack();
       rubberDuck.swim();
       rubberDuck.performFly();
       woodenDuck.display();
       woodenDuck.performQuack();
       woodenDuck.performFly();
    }
}