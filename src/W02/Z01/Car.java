package W02.Z01;

public class Car implements Vehicle{
    private int distance;
    public Car(){
        this.distance = 0;
    }



    @Override
    public void startEngine() {
        if(this.isEngineOk(this.distance))
            System.out.println("Service");
    }

    @Override
    public void move() {

    }
}
