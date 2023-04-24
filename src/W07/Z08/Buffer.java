package W07.Z08;

import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.util.Arrays;

public class Buffer {
    private int[] self;
    private int elementCount=0;
    Buffer(int maxSize){
        if (maxSize<=1)
            throw new IllegalArgumentException("Size has to be over 1");
        this.self = new int[maxSize];
    }
    public void put(int input) throws BufferOverflowException{
        if(this.elementCount == self.length)
            throw new BufferOverflowException();
        this.self[elementCount++]=input;
    }
    public int get() throws BufferUnderflowException{
        if(this.elementCount == 0)
            throw new BufferUnderflowException();
        return this.self[--elementCount];
    }
    public boolean isEmpty(){
        return elementCount==0;
    }
    public boolean isFull(){
        return elementCount==self.length;
    }


    @Override
    public String toString() {
        StringBuilder output = new StringBuilder("Buffer size: ("+this.elementCount+"/"+this.self.length+").\n [");
        for (int i = 0; i < elementCount; i++) {
            output.append(self[i]).append(", ");
        }
        output.append("] \n");
        return output.toString();
    }
}
