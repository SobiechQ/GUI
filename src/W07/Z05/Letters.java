package W07.Z05;

//import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Letters implements Iterable<Thread>{
    Set<Thread> charThreadSet = new HashSet<>();
    Letters(String input){
        input.chars()
                .forEach(inputInt->charThreadSet.add(new Thread(()->{
                    while (!Thread.currentThread().isInterrupted()) {
                        System.out.print((char) inputInt);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            break;
                        }
                    }
                })));
    }
    public Set<Thread> getThreads() {
        return charThreadSet;
    }


    @Override
    public Iterator<Thread> iterator() {
        return charThreadSet.iterator();
    }
}
