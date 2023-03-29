package W04;

import java.util.Iterator;

public class MyArrayStack <T> extends MyArray<T> implements MyStack<T>, Iterable<T>{
    private int lastIndex;

    public MyArrayStack() {
        this.lastIndex =0;
    }

    @Override
    public void push(T ele) {
        this.array[lastIndex++]=ele;

    }

    @Override
    public Iterator<T> iterator() {
        return new myArrayStackIterator();
    }

    @Override
    public T pop() {
        return (T) this.array[--lastIndex];
    }

    private class myArrayStackIterator
        implements Iterator<T> {

        private int count;

        public myArrayStackIterator() {
            this.count = 0;
        }

        @Override
        public boolean hasNext() {
            return this.count<lastIndex;
        }

        @Override
        public T next() {
            return (T) array[count++];
        }
    }
}
