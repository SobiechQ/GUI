package W06;

public class Main {
    public static void main(String[] args) {
        //programowanie współbieżne
        /*var thread = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 20000; i++) {
                    System.out.println("aaaaaaaaaaaaa");
                }
            }
        };
        var thread2 = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 20000; i++) {
                    System.out.println("=========");
                }
            }
        };
        thread.start();
        thread2.start();*/
        class Runner extends Thread{
            private char ch;

            public Runner(char ch) {
                this.ch = ch;
            }


            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {

                    System.out.print(this.ch);
                }
            }
        }
        Runner r1 = new Runner('x');
        Runner r2 = new Runner('d');
//        r1.start();
//        r2.start();
        System.out.println(" ");

        //sunchornizowanie tego co powyżej
        class Runner2 extends Thread{
            private char ch;
            private Thread next;

            public Runner2(char ch) {
                this.ch = ch;
            }

            public void setNext(Thread next) {
                this.next = next;
            }

            @Override
            public void run() {
                synchronized (this){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                for (int i = 0; i < 100; i++) {
                    System.out.print(this.ch);
                    synchronized (next) {
        //wstrzymwanie wait i wznawianie notify
                        next.notify();
                    }
                    synchronized (this){
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }

                }
            }
        }
        Runner2 r3 = new Runner2('x');
        Runner2 r4 = new Runner2('d');
        Runner2 r5 = new Runner2('!');
        r3.setNext(r4);
        r4.setNext(r5);
        r5.setNext(r3);
        r3.start();
        r4.start();
        r5.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        synchronized (r3){
            r3.notify();
            System.out.println(r3.getState());
        }
        //while r1, r2, r3 != WAITING powinno być zrobione





        /*try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(r3.getState());
        synchronized (r3){
            System.out.println(r3.getState());
            //powiadamia r3, że może kontynuwać pracę.
            r3.notify();
        }*/


        //wyscing warunków
        //gdy jednoczensie maja dostep do jednoczenise zasobu, a wynik zalezy od kolejnosci wykonania
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(" ");
        class Counter{
            private int count =0;


            //teraz tylko jeden wątek na raz może używać increase();

            //wstrzymywane są tylko te wątki, które próbują sie dostać do increase.
            //reszta działa niezależnie bardzo dobrze.
            public synchronized void increase(){
                count++;
            }

            public int getCount() {
                return count;
            }
        }
        Counter counter = new Counter();
        System.out.println(counter.getCount());
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 1000; i++) {
                counter.increase();
            }
        });
        Thread t2 = new Thread(()->{
            for (int i = 0; i < 1000; i++) {
                counter.increase();
            }
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(counter.getCount());

        //zakleszczenie wątków, to jak jeden wątek nie ma możliwości pobrania z wątki drugiego, jak dtugi czeka na pierwszy.
        //jeden czeka na drugi a drugi na pierwszy.

        //livelock?

        //interferencja, gdy oba wątki pracują na współdzielonych danych, co prowadzi do nieprzewidywalnych wyników.

        //wielowątkowośc prowadzi do błędów spójności pamięci


    }
}
