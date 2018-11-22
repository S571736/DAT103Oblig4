package no.hvl.dat103.ReaderWriters;

import no.hvl.dat103.Semaphore.semaphore;

public class Reader_Writer {

    public static void main(String[] args) {
        semaphore rw_mutex = new semaphore(1);
        semaphore mutex = new semaphore(1);
        int read_count = 0;

        Read r = new Read(rw_mutex, mutex, read_count);
        Read r2 = new Read(rw_mutex, mutex, read_count);
        Write w = new Write(rw_mutex);

        r2.start();
        System.out.println("r2 kjører");
        r.start();
        System.out.println("r kjører");
        w.start();
        System.out.println("w kjører");

    }
}
