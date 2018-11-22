package no.hvl.dat103.DiningPhilosophers;

import java.util.concurrent.Semaphore;

public class DPJava {

    public static void main(String[] args) {
        PhilosopherJava[] philosophers = new PhilosopherJava[5];
        Semaphore chopstick[] = new Semaphore[philosophers.length];

        for(int i = 0; i < chopstick.length; i++) {
            chopstick[i] = new Semaphore(1);
        }

        for(int j = 0; j < philosophers.length; j++) {
            if(j == philosophers.length - 1) {
                philosophers[j] = new PhilosopherJava(chopstick[(j+1) % philosophers.length], chopstick[j]);
                philosophers[j].start();
            } else {
                philosophers[j] = new PhilosopherJava(chopstick[j], chopstick[(j+1) % philosophers.length]);
                philosophers[j].start();
            }
        }
    }
}
