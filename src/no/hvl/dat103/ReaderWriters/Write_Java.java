package no.hvl.dat103.ReaderWriters;

import java.util.concurrent.Semaphore;

public class Write_Java extends Thread {
    Semaphore rw_mutex;

    public Write_Java(Semaphore rw_mutex) {
        this.rw_mutex = rw_mutex;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(500);
                System.out.println(Thread.currentThread().getName() + ": rw_mutex acquiring in write");
                rw_mutex.acquire();
                System.out.println(Thread.currentThread().getName() + ": rw_mutex acquired in write");
                //writing
                Thread.sleep(100);
                System.out.println("Some Thread is writing");
                rw_mutex.release();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

