package W04.Z09;

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


        var listMapByString = new TreeMap<String, List<Samochod>>(){
            public Samochod getCheapest(){
                Samochod tmpCheapest = new Samochod(null, null, Integer.toString(Integer.MAX_VALUE));
                for (String s : this.keySet()) {
                    for (Samochod samochod : this.get(s)) {
                        if( Integer.parseInt(samochod.getCena()) < Integer.parseInt(tmpCheapest.getCena()))
                            tmpCheapest = samochod;
                    }
                }
                return tmpCheapest;
            }
        };

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
        //Wypisuje wszystkie.
        System.out.println(listMapByString);
        System.out.println(listMapByString.getCheapest());

    }
}
