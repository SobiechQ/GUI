package W07.Z06;

public class StringTask implements Runnable {
    private String tmpResult = "";
    private final String toBeCopied;
    private int iterationsLeft;
    private Thread currentThread;
    private StringTaskState currentState;

    public StringTask(String toBeCopied, int iterations) {
        this.toBeCopied = toBeCopied;
        this.iterationsLeft = iterations;
        this.currentState = StringTaskState.CREATED;
    }

    @Override
    public void run() {
        this.currentThread = new Thread(()->{
            this.currentState = StringTaskState.RUNNING;
            for (int i = iterationsLeft; i > 0; i--) {
                for (int j = toBeCopied.length()-1; j >=0  ; j--) {
                    tmpResult +=toBeCopied.charAt(j);
                }
            }
            this.currentState = StringTaskState.READY;
        });
        this.currentThread.start();
    }
    public void start(){
        this.run();
    }

    public String getResult() {
        return tmpResult;

    }
    public void abort(){
        this.currentState = StringTaskState.ABORTED;
        this.currentThread.interrupt();
    }
    public boolean isDone(){
        return this.currentState == StringTaskState.READY || this.currentState == StringTaskState.ABORTED;
    }

    public StringTaskState getState() {
        return currentState;
    }
    public String getTxt(){
        return this.toBeCopied;
    }


    public enum StringTaskState {
        CREATED, RUNNING, ABORTED, READY
    }


}
