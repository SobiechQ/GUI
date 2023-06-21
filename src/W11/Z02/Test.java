package W11.Z02;

class Destroy implements AutoCloseable{
    private static int i = 0;
    public int id;

    public Destroy() {
        id = i++;
    }
    public void foo(){
        System.out.println("Foo! (" + this.id+") ");
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closed");
    }
}

public class Test {
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            try (var destroy = new Destroy()){
                destroy.foo();
            } catch (Exception e){
                //handle ex
            }
        }
    }
}
