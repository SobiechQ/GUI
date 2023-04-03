import Z02.Osoba;

import java.util.EmptyStackException;
import java.util.Iterator;
public class MyStack<T> implements Iterable<Element>{
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

    public Element getHead() {
        return head;
    }

    @Override
    public Iterator iterator() {
        return new Iterator<>() {
            private Element tmp = getHead();

            @Override
            public boolean hasNext() {
                return tmp!=null;
            }

            @Override
            public Element next() {
                Element<T> prev = tmp;
                tmp = tmp.getNext();
                return prev;
            }
        };
    }
}