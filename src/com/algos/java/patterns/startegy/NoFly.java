package com.algos.java.patterns.startegy;

public class NoFly implements IFlyBehaviour{

	@Override
	public void fly() {
		System.out.println("I cant Fly!!");
	}
	
	

}
