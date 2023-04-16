package W06.Z04;

public class Main {
    static class MyTask {
        public static void myWait(){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("compleated");
        }
        public static void printChar(char c){
            for (int i = 0; i < 1000; i++) {
                System.out.print(c);
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        /*
        Thread t1 = new Thread(MyTask::myWait);
        Thread t2 = new Thread(MyTask::myWait);
        Thread t3 = new Thread(MyTask::myWait);
        Thread t4 = new Thread(MyTask::myWait);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        */
        class MySynchronizedThread
            extends Thread{
            private Runnable next;
            private char toDraw;

            public MySynchronizedThread(char toDraw) {
                this.toDraw = toDraw;
            }

            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    synchronized (this) {
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        System.out.print(this.toDraw);
                    }
                    synchronized (this.next) {
                        this.next.notify();
                    }
                }


            }
            public void setNext(Runnable next) {
                this.next = next;
            }
        }
        MySynchronizedThread mst1 = new MySynchronizedThread('a');
        MySynchronizedThread mst2 = new MySynchronizedThread('b');
        MySynchronizedThread mst3 = new MySynchronizedThread('c');
        MySynchronizedThread mst4 = new MySynchronizedThread('d');
        mst1.setNext(mst2);
        mst2.setNext(mst3);
        mst3.setNext(mst4);
        mst4.setNext(mst1);
        mst1.start();
        mst2.start();
        mst3.start();
        mst4.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        synchronized (mst1) {
            mst1.notify();
        }



    }
}
