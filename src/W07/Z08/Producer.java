package W07.Z08;

import java.nio.BufferOverflowException;

public class Producer implements Runnable {
    final Buffer buffer;
    private int index=1;

    Producer(Buffer b) {
        this.buffer = b;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep((long) (1500+Math.random()*5000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }



            try {
                int tmpPut = index++;
                buffer.put(tmpPut);
                System.out.println("Dodano wartosc. " + tmpPut);
                System.out.println(buffer);
                synchronized (this.buffer){
                    buffer.notify();
                }



            } catch (BufferOverflowException e) {
                synchronized (buffer) {
                    while (buffer.isFull()){
                        try {
                            System.out.println("Unable to add. Buffer overflow \nWaiting...\n");
                            buffer.wait();
                        } catch (InterruptedException ex) {
                            throw new RuntimeException(ex);
                        }

                    }
                    buffer.notify();
                }
            }



        }
    }
}