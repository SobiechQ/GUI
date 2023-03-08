public class MyList {
    private Element head;
    private MyList next;
    public MyList(){

    }
    public MyList(Element head){
        this.head=head;
    }
    private MyList(Element head, MyList next){
        this.head=head;
        this.next=next;
    }

    public void pushTop(Element input){
        if(this.head==null)
            this.head=input;
        this.next = new MyList(input, this.getNext());
    }
    public Element popTop(){
        Element tmp = this.getHead();
        this.getNext()
        return tmp;
    }
    public void sout(){
        MyList tmp = this;
        while (tmp!=null){
            System.out.println(tmp.getHead().getIndex());
            tmp=tmp.getNext();
        }

    }

    public Element getHead() {
        return head;
    }

    public void setHead(Element head) {
        this.head = head;
    }

    public MyList getNext() {
        return next;
    }

    public void setNext(MyList next) {
        this.next = next;
    }
    public boolean isNull(){
        return this.head==null;
    }
}
