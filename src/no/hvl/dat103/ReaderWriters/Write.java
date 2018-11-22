package no.hvl.dat103.ReaderWriters;

import no.hvl.dat103.Semaphore.semaphore;

public class Write extends Thread {
    semaphore rw_mutex;

    public Write(semaphore rw_mutex) {
        this.rw_mutex = rw_mutex;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(500);
                rw_mutex.waiting();
                //writing
                Thread.sleep(100);
                rw_mutex.signal();

            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
