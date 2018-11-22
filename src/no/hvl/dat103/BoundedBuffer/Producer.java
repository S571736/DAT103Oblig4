package no.hvl.dat103.BoundedBuffer;

import java.util.Random;

public class Producer extends Thread {
    Random rand = new Random();
    private BufferInterface buffer;

    /**
     * Constructs a new producer.
     *
     * @param buffer The shared buffer
     */

    public Producer(BufferInterface buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            Integer item = rand.nextInt(100);
            buffer.consume(item);
            System.out.println("Produced: " + item);

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.getMessage();
            }
            // ignore
        }
    }
}

