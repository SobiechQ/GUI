package W07.Z08;

import java.nio.BufferUnderflowException;

public class Consumer implements Runnable {
    final Buffer buffer;

    Consumer(Buffer b) {
        this.buffer = b;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep((long) (1500+Math.random()*1000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            try {
                System.out.println("Pobrano wartosc: "+buffer.get());
                System.out.println(buffer);
                synchronized (this.buffer){
                    this.buffer.notify();
                }



            } catch (BufferUnderflowException e) {
                synchronized (this.buffer) {
                    while (buffer.isEmpty()){
                        try {
                            System.out.println("Unable to read. Buffer is Empty \nWaiting...\n");
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