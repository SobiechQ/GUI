package W06.Z05;

import java.time.Duration;
import java.time.Instant;


public class Main {
    public static void main(String[] args) {
        System.out.println("Program started!");
        if(args.length!=2)
            throw new IllegalArgumentException("Incorrect parameters. \n\t execute this JAR with parameters (long), (int)");
        long complexity;
        int thread;
        try {
            complexity = Long.parseLong(args[0]);
            thread = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Incorrect parameters. \n\t execute this JAR with parameters (long), (int)");
        }
        Instant start = Instant.now();
        MyMath.piGeneration(10);
        System.out.println(MyMath.piGenerationMultiThread(complexity, thread));
        Instant end = Instant.now();
        System.out.println("Multi Thread:" + Duration.between(start, end));

    }
}
