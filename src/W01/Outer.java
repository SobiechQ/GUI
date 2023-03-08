package W01;

public class Outer {
    private int inerInt =6;



    public class Inner {

        public int getCount(){
            return inerInt;
        }

    }
    public static class StatInner{


        public static void dupa(){

            int i = new Object(){

                public int val =127;

                public int getVal() {
                    return val;
                }
            }.getVal();

            Object obj = new Object(){

                public int val =127;

                public int getVal() {
                    return val;
                }
            };


//            obj.getWrt() // nie ma takiej metody w obectie
            System.out.println(i);

            var dwa = new Object(){

                public int val =127;

                public int getVal() {
                    return val;
                }
            };
            System.out.println(dwa.getClass());



        }

    }





}
