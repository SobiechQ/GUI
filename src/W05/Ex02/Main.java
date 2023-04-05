package W05.Ex02;

public class Main {
    public static void main(String[] args) {
        //program współbierzny to taki, dla któego jest jeden rzepływ sterowania

        //każdy przepływ sterowania jest realizowany prezz odrębny wątek
        //początkowo wykonuje się tylko wątek główny i wątki systemowe.

        //program wielowątkowy zachowike się tak, jakby każdy przepłwy sterowania był realizowany przez odzielny procesor
        @Deprecated(forRemoval = true) //ponieważ
        class Runner
            extends Thread{
            //gdy dziedziczy po thread to nie może po czym kolwiek innym.

            //Lepiej: implementuj Runnable

            private String id;

            public Runner(String id) {
                this.id = id;
            }

            @Override
            public void run() {
                for (int i = 0; i < 1000; i++)
                    System.out.println(this.id+" : "+i);
            }
        }
        //uruchamia się metodą START!
        new Runner("Thread 1").start();
        new Runner("Thread 2").start();
        //oba wykonują się na raz

        new Thread(new Runner("Thread 3")).start();
    }
}
