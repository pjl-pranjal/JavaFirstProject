package com.sapient.week5;

public class App {
	public static void main(String[] args) {
		BO bo = new BO();

		bo.read();
		bo.read();
		bo.read();
		bo.display(5);
		bo.displaySorted(false);
	}
}
