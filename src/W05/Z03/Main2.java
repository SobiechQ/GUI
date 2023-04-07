package W05.Z03;

import MODEL.Person;

public class Main2 {
    public static void main(String[] args) {
        var person = new Person(10, "Jan", "Matejko", "hip-hop"){
            @Override
            public String getFirstName() {
                return super.getFirstName() +" :) ";
            }
            public double wiekDoKwadratu(){
                return Math.pow(this.getAge(), 2);
            }
        };
        var person2 = new Person(21, "mikolaj", "sobiech", "jazz"){
            @Override
            public String getFirstName() {
                return super.getFirstName() +" :) ";
            }
            public double wiekDoKwadratu(){
                return Math.pow(this.getAge(), 2);
            }
        };
        Person[] people = {person, person2};
    }
}
