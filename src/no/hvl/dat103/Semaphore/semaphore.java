package no.hvl.dat103.Semaphore;

import java.sql.SQLOutput;

public class semaphore {


    private int S;

    public semaphore(int S) {
        this.S = S;
    }

    public synchronized void waiting() {

        while (!ledig()) ;

        System.out.println("Waiting... \nS: " + S);
        synchronized (this) {
            S--;
        }
        System.out.println("Done Waiting");
    }

    public void signal() {

            S++;
    }

    public int getSem() {
        return S;
    }

    public void setSem(int S) {
        this.S = S;
    }

    public synchronized boolean ledig() {
        return S >= 0;
    }
}
