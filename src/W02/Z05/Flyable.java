package W02.Z05;

public interface Flyable {
    String drive();
    double distance();
    static Flyable hybrid(Flyable fl1, Flyable fl2){
        return new Flyable() {
            @Override
            public String drive() {
                return fl1.drive()+fl2.drive();
            }

            @Override
            public double distance() {
                return Math.max(fl1.distance(), fl2.distance());
            }
        };
    }
    static Flyable najdalej(Flyable[] input){
        Flyable tmp=input[0];
        for (Flyable f : input) {
            if(f.distance()> tmp.distance())
                tmp=f;
        }
        return tmp;
    }




}
