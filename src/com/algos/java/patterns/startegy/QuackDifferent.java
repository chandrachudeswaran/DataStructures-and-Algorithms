package com.algos.java.patterns.startegy;

public class QuackDifferent implements IQuackBehaviour {

	@Override
	public void quack() {
		System.out.println("Quacking differently");
	}

}
