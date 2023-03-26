
public class Main {
    public static void main(String[] args) {
        Flyable golab = new Bird();
        Flyable boeing = new Plane();
        Flyable golabBoeing = Flyable.hybrid(golab,boeing);
        System.out.println("Hybryda: "+golabBoeing.drive());
        System.out.println("Hybryda: "+golabBoeing.distance());
        Flyable vir01 = new Virus();
        Flyable vir02 = new Virus();

        Flyable[] fl = {golab, boeing, golabBoeing};
        System.out.println("Najdalej: "+Flyable.najdalej(fl).distance());




        Speakable wrona = new Bird(){
            @Override
            public String speak() {
                return "crawcraw";
            }
        };
        Speakable wrobel = new Bird();
        Speakable paw = new Bird(){
            @Override
            public String speak() {
                return "...";
            }
        };
        Speakable[] sp = {wrona, wrobel, paw};
        System.out.println("Najglosniej: "+Speakable.naglosniej(sp).speak());




    }


    //Klasy zanurzone.
    public static class Bird
    implements Flyable, Speakable{
        @Override
        public String drive() {
            return "Skrzydlo";
        }

        @Override
        public double distance() {
            return 132.7;
        }

        @Override
        public String speak() {
            return "CwirCwirCwir";
        }
    }
    public static class Plane
    implements Flyable, Speakable{
        @Override
        public String drive() {
            return "General Electric";
        }

        @Override
        public double distance() {
            return 2470;
        }

        @Override
        public String speak() {
            return "ZIUUUUUUUU";
        }
    }
    public static class UFO
    implements Flyable, Speakable {

        @Override
        public String drive() {
            return "Magia";
        }

        @Override
        public double distance() {
            return 99999.99;
        }

        @Override
        public String speak() {
            return "100110010101";
        }
    }
    public static class Virus
    implements Flyable{
        @Override
        public String drive() {
            return "Powetrze";
        }

        @Override
        public double distance() {
            return 0.001;
        }
    }







}
