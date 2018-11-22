package no.hvl.dat103.BoundedBuffer;


public interface BufferInterface {
    public void consume(Integer item);
    public Integer remove();
    public int antall();



}
