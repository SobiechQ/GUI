package W09.Z01;

class Resource {
    private final int[] array = new int[5];
    private int length = 0;

    public void push(int i) {
        this.array[this.length++] = i;
    }

    public int pop() {
        return this.array[length--];
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < this.length; i++)
            output.append(this.array[i]).append(", ");
        return output.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        Resource resource = new Resource();



        System.out.println(resource);
    }
}
