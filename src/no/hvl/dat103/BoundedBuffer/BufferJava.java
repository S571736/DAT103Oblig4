package no.hvl.dat103.BoundedBuffer;


import java.util.LinkedList;
import java.util.concurrent.Semaphore;

public class BufferJava implements BufferInterface {

    private final static int SIZE = 10;
    Semaphore mutex = new Semaphore(1);
    Semaphore empty = new Semaphore(SIZE);
    Semaphore full = new Semaphore(0);
    private LinkedList<Integer> buffer = new LinkedList<Integer>();

    public void consume(Integer item) {
        try {
            empty.acquire();
            mutex.acquire();

        } catch (InterruptedException e) {

            e.printStackTrace();
        }

        buffer.add(item);
        mutex.release();
        full.release();

    }

    public Integer remove() {
        while (true) {
            try {
                if (buffer.isEmpty()) {
                    System.out.println("List is empty, waiting...");
                    full.acquire();
                    mutex.acquire();
                } else {
                    int back = buffer.removeFirst();
                    mutex.release();
                    empty.release();
                    return back;
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public int antall() {
        return buffer.size();
    }

}

