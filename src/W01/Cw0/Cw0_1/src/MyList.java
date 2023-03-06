public class MyList {
    private Path head;
    private MyList next;
    public void add(Path input){
        if(this.head==null) {
            this.head = input;
            return;
        }
        MyList tmp = this;
        while (tmp.getNext()!=null)
            tmp=tmp.getNext();
        this.next=new MyList(input);
    }
    protected MyList(){}
    private MyList(Path head){
        this.head=head;
    }

    public MyList getNext() {
        return next;
    }

    public void setNext(MyList next) {
        this.next = next;
    }

    public Path getHead() {
        return head;
    }
}
