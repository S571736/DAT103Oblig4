package no.hvl.dat103.ReaderWriters;

import java.util.concurrent.Semaphore;

public class Reader_Writer_Java {
    public static void main(String[] args) {
        Semaphore rw_mutex = new Semaphore(1);
        Semaphore mutex = new Semaphore(1);
        int read_count = 0;

        Read_Java r = new Read_Java(rw_mutex, mutex, read_count);
        Write_Java w = new Write_Java(rw_mutex);

        w.start();
        r.start();
    }
}
