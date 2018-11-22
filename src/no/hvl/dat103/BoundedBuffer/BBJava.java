package no.hvl.dat103.BoundedBuffer;

public class BBJava {

    public static void main (String[] args) {
        BufferInterface buffer = new BufferJava();
        Consumer consumer = new Consumer(buffer);
        Producer producer = new Producer(buffer);
        producer.start();
        consumer.start();


    }
}
