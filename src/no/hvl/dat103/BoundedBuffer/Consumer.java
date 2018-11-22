package no.hvl.dat103.BoundedBuffer;

public class Consumer extends Thread {
    BufferInterface buffer;

    public Consumer(BufferInterface buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            Integer item = buffer.remove();

            System.out.println("Consumed: " + item + "\tAntall på lager: " + buffer.antall());

            try {

                Thread.sleep(50);

            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

