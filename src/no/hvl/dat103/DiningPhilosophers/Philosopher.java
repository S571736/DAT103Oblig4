package no.hvl.dat103.DiningPhilosophers;

import no.hvl.dat103.Semaphore.semaphore;

public class Philosopher extends Thread{
    semaphore right;
    semaphore left;

    public Philosopher(semaphore right, semaphore left) {
        this.right = right;
        this.left = left;
    }

    @Override
    public void run() {
        while (true) {
            try {
                left.waiting();
                right.waiting();
                System.out.println("Philosopher : " + currentThread().getName() + " is eating.");
                sleep(100);
                System.out.println("Philosopher : " + currentThread().getName() + " is thinking.");
                left.signal();
                right.signal();
                sleep(50);
            } catch (InterruptedException e ) {
                System.out.println(e.getMessage());
            }

        }
    }

}
