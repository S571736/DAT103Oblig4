package no.hvl.dat103.DiningPhilosophers;


import javax.swing.plaf.SeparatorUI;
import java.util.concurrent.Semaphore;

public class PhilosopherJava extends Thread{

    Semaphore right;
    Semaphore left;

    public PhilosopherJava(Semaphore right, Semaphore left) {
        this.right = right;
        this.left = left;
    }

    @Override
    public void run() {
        while(true) {
            try {
                left.acquire();
                right.acquire();
                System.out.println("Philosopher : " + currentThread().getName() + " is eating.");
                sleep(100);
                System.out.println("Philosopher : " + currentThread().getName() + " is thinking.");
                left.release();
                right.release();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
