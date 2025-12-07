package edu.learning;

public abstract class Duck {

    private QuackBehaviour quackBehaviour;
    private FlyBehaviour flyBehaviour;

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

    public void setFlyBehaviour(FlyBehaviour flyBehaviour){
        this.flyBehaviour = flyBehaviour;
    }
    public  void setQuackBehaviour(QuackBehaviour quackBehaviour){
        this.quackBehaviour = quackBehaviour;
    }
}
