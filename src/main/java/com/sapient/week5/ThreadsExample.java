package com.sapient.week5;

class TickTock {
	int counter = 1;
	String curState;
	boolean semaphore = true;

	synchronized void tick(boolean running) {
		if (this.semaphore)
			this.semaphore = false;

		if (!running) {
			this.curState = "tick done";
			notify();
			return;
		}

		System.out.print(this.counter + ". Tick-");
		this.curState = "tick done";
		this.counter += 1;
		notify();

		try {
			while(!this.curState.equals("tock done"))
				wait();
		} catch (InterruptedException e) {
			System.out.println(e);
		}
	}

	synchronized void tock(boolean running) {
		if (this.semaphore) {
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}

		if (!running) {
			this.curState = "tock done";
			notify();
			return;
		}

		System.out.print("Tock ");
		System.out.println();
		this.curState = "tock done";
		notify();

		try {
			while(!this.curState.equals("tick done"))
				wait();
		} catch (InterruptedException e) {
			System.out.println(e);
		}
	}
}

class Runner implements Runnable {
	Thread thread;
	TickTock tickTockOb;
	int printCount = 10;

	public Runner(String name, TickTock tickTockOb) {
		this.thread = new Thread(this, name);
		this.tickTockOb = tickTockOb;
		this.thread.start();
	}
	
	public void run() {
		if (this.thread.getName().compareTo("Tick") == 0) {
			for (int i = 0; i < this.printCount; i++)
				this.tickTockOb.tick(true);
			this.tickTockOb.tick(false);
		} else {
			for (int i = 0; i < this.printCount; i++)
				this.tickTockOb.tock(true);
			this.tickTockOb.tock(false);
		}
	}
}

public class ThreadsExample {
	public static void main(String[] args) {
		TickTock tickTockOb = new TickTock();
		Runner ob1 = new Runner("Tick", tickTockOb);
		Runner ob2 = new Runner("Tock", tickTockOb);

		try {
			ob1.thread.join();
			ob2.thread.join();
		} catch (InterruptedException e) {
			System.out.println(e);	
		}
	}
}
