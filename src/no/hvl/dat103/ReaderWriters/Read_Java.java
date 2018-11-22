package no.hvl.dat103.ReaderWriters;

import java.util.concurrent.Semaphore;

public class Read_Java extends Thread{
    Semaphore rw_mutex;
    Semaphore mutex;
    int read_count;

    public Read_Java(Semaphore rw_mutex, Semaphore mutex, int read_count) {
        this.rw_mutex = rw_mutex;
        this.mutex = mutex;
        this.read_count = read_count;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(500);
                mutex.acquire();
                read_count++;
                System.out.println(Thread.currentThread().getName() + ": ");
                if (read_count == 1) {
                    System.out.println(Thread.currentThread().getName() + ": rw_mutex acquiring in read");
                    rw_mutex.acquire();
                    System.out.println(Thread.currentThread().getName() + ": rw_mutex acquired in read");
                }
                mutex.release();
                Thread.sleep(50);
                //reading
                System.out.println(Thread.currentThread().getName() + ": is Reading");
                mutex.acquire();
                System.out.println(Thread.currentThread().getName() + ": mutex acquired in read");
                read_count--;
                if (read_count == 0)
                    rw_mutex.release();
                mutex.release();
                Thread.sleep(50);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
