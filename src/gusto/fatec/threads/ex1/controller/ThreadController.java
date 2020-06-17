package gusto.fatec.threads.ex1.controller;

public class ThreadController extends Thread {
	
	private long id;
	
	public ThreadController() {
		id = 0;
	}
	
	private void setId() {
		id = getId();
		
		System.out.println(id);
	}
	
	@Override
	public void run() {
		setId();
	}
}
