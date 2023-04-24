package W07.Z07;

public class Main {
    public static void main(String[] args) {
        Integer[] integer = {2};


        Thread thread = new  Thread(()->{
            int i=0;
            while (true){
                synchronized (integer) {
                    i += 1;
                    if (i % 100 == 0)
                        System.out.print(integer[0]);
                }
            }
        });
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        synchronized (integer){
            try {
                integer.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            for (int i = 0; i < 100; i++) {
                System.out.print("abc");
            }
            System.exit(0);

        }

    }
}
