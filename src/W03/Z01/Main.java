package W03.Z01;

import W02.Z01.Drawable;

public class Main {
    public static void main(String[] args) {
        Figura[] fig = new Figura[2];
        fig[0] = new Kolo(10, 10, 5);
        fig[1] = new Prostokat(20, 20, 15, 10);
        for (Figura f : fig)
            System.out.println(f);

        fig[0].pozycja(12, 12);
        fig[1].pozycja(25, 30);
        class Prostokat2 extends Prostokat implements Rysowanie {
            char toDraw;
            public Prostokat2(int xPos, int yPos, int width, int height, char toDraw) {
                super(xPos, yPos, width, height);
                this.toDraw = toDraw;
            }

            @Override
            public void rysuj(){
                for (int i = 0; i < this.getHeight(); i++) {
                    for (int j = 0; j < this.getWidth(); j++) {
                        System.out.print(this.toDraw);
                    }
                    System.out.println();
                }
            }
        }
        Figura p2 = new Prostokat2(10,10,7,11, '*');
        ((Prostokat2)p2).rysuj();


        System.out.println("========================");
        class Kolo2 extends Kolo implements Transformacja{
            int lastPosX = this.getxPos();
            int lastPosY = this.getyPos();
            public Kolo2(int xPos, int yPos, int radius) {
                super(xPos, yPos, radius);
            }


            @Override
            public void przesunDo(int x, int y) {
                this.lastPosX = this.getxPos();
                this.lastPosY = this.getyPos();
                this.setxPos(x);
                this.setyPos(y);
            }

            @Override
            public void powrot() {
                this.setxPos(this.lastPosX);
                this.setyPos(this.lastPosY);
            }
        }
        Kolo2 k2 = new Kolo2(15, 20, 5);

        k2.przesunDo(50, 40);    // przesunięcie środka koła do punktu (50, 40)
        System.out.println(k2);

        k2.powrot();                    // powrót do poprzedniej pozycji (bezpośrednio przed przesunięciem) środka koła
        System.out.println(k2);








    }
}
