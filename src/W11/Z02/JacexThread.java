package W11.Z02;

public class JacexThread extends Thread{
    private static int threadCount = 0;
    private final StringBuilder stringBuilder;

    public JacexThread() {
        this.stringBuilder = new StringBuilder();
        threadCount++;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100_000_000/threadCount; i++)
            stringBuilder.append("jacex");
    }
}
