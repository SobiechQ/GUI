package W05.Ex01;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        //można tak ale to nie jest na srumieniu.
        /*
        List<Item> listItem = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            Item item = new Item(
                    (int) (Math.random() * 99),
                    (int) (Math.random() * 99)
            );
            listItem.add(item);
        }
        listItem.stream().forEach(System.out::println);
        */
        class MyCollectionTask {
            private List<MyItem> myItemList;
            private MyCollectionTask(){
                this.myItemList = new LinkedList<>();
            }
            private void accept(Integer iVal){
                myItemList.add(
                        new MyItem(iVal, 0)
                );
                //tu można da buffor że czeka na wejście jednej wartości potem drugiej
                //robi nowy obiekt tylko dla pełnego bufora


            }
            private MyCollectionTask combine(MyCollectionTask otherMCT){
                throw new UnsupportedOperationException();
            }
            private void finish(){

            }
            public static Collector<Integer, ? , List<MyItem>> collector(){
                throw new UnsupportedOperationException("i am a dumbass");
                //todo to:
                /*
                return Collector.of(
                        MyCollectionTask::new,
                        MyCollectionTask::accept,
                        MyCollectionTask::combine,
                        MyCollectionTask::finish
                );
                */
            }



        }


        List<MyItem> myItemList = Stream
                .generate(Math::random)
                .limit(10)
                .map(v -> (int)(v*99))
                .collect(MyCollectionTask.collector());



    }
}
