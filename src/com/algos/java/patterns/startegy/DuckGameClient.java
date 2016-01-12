package com.algos.java.patterns.startegy;

// This is the client for the Duck Game 
public class DuckGameClient {

	public static void main(String[] args) {
		Duck duck = new MallardDuck();
		duck.display();
		duck.performFly();
		duck.performQuack();
		
		
		duck.setFlyBehaviour(new FlyRocket());
		duck.performFly();

	}

}
