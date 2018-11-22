package no.hvl.dat103.DiningPhilosophers;

import no.hvl.dat103.Semaphore.semaphore;

public class Dining_Philosophers {

    public static void main(String[] args) {
        Philosopher[] philosophers = new Philosopher[5];
        semaphore chopstick[] = new semaphore[philosophers.length];

        for(int i = 0; i < chopstick.length; i++) {
            chopstick[i] = new semaphore(1);
        }

        for(int j = 0; j < philosophers.length; j++) {
            if (j == philosophers.length -1) {
                philosophers[j] = new Philosopher(chopstick[(j+1) % philosophers.length], chopstick[j]);
                philosophers[j].start();
            } else {
                philosophers[j] = new Philosopher(chopstick[j], chopstick[(j+1) % philosophers.length]);
                philosophers[j].start();
            }
        }
    }
}
