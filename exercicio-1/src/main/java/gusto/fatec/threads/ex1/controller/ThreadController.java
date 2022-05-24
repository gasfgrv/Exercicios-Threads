package gusto.fatec.threads.ex1.controller;

public class ThreadController extends Thread {
    @Override
    public void run() {
        System.out.println(getId());
    }

}
