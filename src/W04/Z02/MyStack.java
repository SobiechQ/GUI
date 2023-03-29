package W04.Z02;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class MyStack<T> implements Iterable{
    private Element<T> head;
    public void push(T input){
        if(this.head == null){
            this.head = new Element<>(input);
            return;
        }
        Element<T> tmp = this.head;
        this.head = new Element<>(input);
        this.head.setNext(tmp);
    }
    public T pop(){
        if (this.head == null)
            throw new EmptyStackException();

        Element<T> tmp = this.head;
        this.head = this.head.getNext();
        return tmp.getIt();
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Object next() {
                return null;
            }
        };
    }


}
