package no.hvl.dat103.BoundedBuffer;


public class Bounded_buffer {

    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        Consumer consumer = new Consumer(buffer);
        Producer producer = new Producer(buffer);
        producer.start();
        consumer.start();
    }
}
