package W04.Z10;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] arr = {
                "salon A", "Mercedes", "130000",
                "salon B", "Mercedes", "120000",
                "salon C", "Ford", "110000",
                "salon B", "Opel", "90000",
                "salon A", "Dodge", "3000",
                "salon C", "Honda", "95000",
                "salon A", "Ford", "105000",
                "salon A", "Renault", "75000",
        };

        class MyTreeMap<K,V> extends TreeMap<K,V> implements Iterable<V>{
            @Override
            public Iterator<V> iterator() {
                return new Iterator<>() {
                    private ArrayList<K> keys = new ArrayList<>(keySet());
                    private int keyIndex = 0;
                    @Override
                    public boolean hasNext() {
                        return keyIndex<keys.size();
                    }

                    @Override
                    public V next() {
                        return get(keys.get(keyIndex++));
                    }
                };
            }

        }
        MyTreeMap<String, List<Samochod>> listMapByString = new MyTreeMap<>();


        for (int i = 0; i < arr.length; i+=3) {
            if (listMapByString.get(arr[i]) == null) {
                listMapByString.put(arr[i], new ArrayList<>(){
                    @Override
                    public String toString() {
                        return '\n'+super.toString()+'\n';
                    }
                });
            }
            listMapByString.get(arr[i]).add(new Samochod(arr[i], arr[i+1], arr[i+2]));
        }

        Samochod tmpLowest = new Samochod(null, null, Integer.toString(Integer.MAX_VALUE));
        for (List<Samochod> samochods : listMapByString) {
            for (Samochod samochod : samochods) {
                if(Integer.parseInt(samochod.getCena()) < Integer.parseInt(tmpLowest.getCena()))
                    tmpLowest = samochod;
            }
        }
        System.out.println(tmpLowest);

    }
}
