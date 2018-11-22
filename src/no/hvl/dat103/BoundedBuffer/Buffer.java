package no.hvl.dat103.BoundedBuffer;

import no.hvl.dat103.Semaphore.semaphore;

import java.util.LinkedList;

public class Buffer implements BufferInterface {
    private final static int SIZE = 1;
    semaphore mutex = new semaphore(1);
    semaphore empty = new semaphore(SIZE);
    semaphore full = new semaphore(0);
    private LinkedList<Integer> buffer = new LinkedList<Integer>();

    public void consume(Integer item) {
        empty.waiting();
        mutex.waiting();

        System.out.println("Consuming");
        synchronized (buffer) {
            buffer.add(item);
        }
        mutex.signal();
        full.signal();
    }

    /**
     * Remove next available item from the buffer. If the buffer is empty, wait.
     *
     * @return next item
     */
    public Integer remove() {
        while (true) {

            if (buffer.isEmpty()) {
                System.out.println("List is empty! Waiting..");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            } else {
                full.waiting();
                mutex.waiting();
                int back = buffer.removeFirst();
                mutex.signal();
                empty.signal();
                return back;

            }
        }


    }

    public int antall() {
        return buffer.size();
    }
}
