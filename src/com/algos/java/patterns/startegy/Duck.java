package com.algos.java.patterns.startegy;

public abstract class Duck {

	IFlyBehaviour flyBehaviour;
	IQuackBehaviour quackBehaviour;
	
	//Dynamically selects Fly behaviour for the duck
	public void performFly(){
		flyBehaviour.fly();
	}
	//Dynamically selects quack behaviour for the duck
	public void performQuack(){
		quackBehaviour.quack();
	}

	public void swim() {
		System.out.println("All ducks can swim");
	}

	// To be inherited method in all subclasses of Duck
	public abstract void display();
	
	//Change Fly behaviour for any Duck using setter
	public void setFlyBehaviour(IFlyBehaviour flyBehaviour){
		this.flyBehaviour = flyBehaviour;
	}

}
