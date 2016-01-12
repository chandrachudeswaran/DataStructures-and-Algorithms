package com.algos.java.patterns.startegy;

public class MallardDuck extends Duck {

	@Override
	public void display() {
		System.out.println("I am Mallard Duck");
	}
	
	public MallardDuck(){
		flyBehaviour= new FlyWithWings();
		quackBehaviour = new QuackDifferent();
	}
	
	

}
