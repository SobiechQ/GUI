package W07.Z05;

import java.util.Arrays;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws InterruptedException{
        Letters letters = new Letters("ABCD");
        for (Thread t : letters.getThreads())
            System.out.println(t.getName());
        for (Thread t : letters)
            t.start();
        Thread.sleep(5000);
        for(Thread t: letters)
            t.interrupt();

    }
}
