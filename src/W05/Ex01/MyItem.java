package W05.Ex01;

public class MyItem {
    private Integer x,y;

    public MyItem(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Item{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
