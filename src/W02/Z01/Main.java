package W02.Z01;


import java.lang.annotation.Annotation;

public class Main {
    public static void main(String[] args) {
        //jeżeli interjsej zawiera dokłądnie jeden nagłówek niezaimplementowanej metody wówczas jest funkcyjny.



        Drawable drawable = () -> {
            System.out.println("abc");
        };
        drawable.draw();
//        sMet(
//                new FunctionalInterface(){
//                    @Override
//                    public Class<? extends Annotation> annotationType() {
//                        return null;
//                    }
//                }
//        );

        //to powinno działać HALO??
//        sMet( () -> {
//            System.out.println("abc");
//        });
//        Dodaj dodaj = (10,40) -> c*d //jakos to sie da tak zrobic ale nie wiem jak 
    }
    public static void sMet(FunctionalInterface fi){

    }
}
