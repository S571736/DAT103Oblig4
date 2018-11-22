package no.hvl.dat103.ReaderWriters;

import no.hvl.dat103.Semaphore.semaphore;


public class Read extends Thread {
    semaphore rw_mutex;
    semaphore mutex;
    int read_count;
    String name = Thread.currentThread().getName();

    public Read(semaphore rw_mutex, semaphore mutex, int read_count) {
        this.rw_mutex = rw_mutex;
        this.mutex = mutex;
        this.read_count = read_count;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(500);
                mutex.waiting();
                read_count++;
                if (read_count == 1) {
                    rw_mutex.waiting();
                }
                mutex.signal();
                Thread.sleep(50);
                //reading
                mutex.waiting();
                read_count--;
                if (read_count == 0) {
                    rw_mutex.signal();
                }
                mutex.signal();
                Thread.sleep(50);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
