package com.algos.java.patterns.startegy;

public class DecoyDucks extends Duck {

	@Override
	public void display() {
		System.out.println("I am a Decoy Duck");
	}
	
	public DecoyDucks(){
		flyBehaviour = new NoFly();
		quackBehaviour = new Squeak();
	}

}
