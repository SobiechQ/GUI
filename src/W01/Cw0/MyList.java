package W01.Cw0;

public class MyList{
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
        if(this.head==null) {
            this.head = input;
            return;
        }
        MyList tmpNewMyList = new MyList(this.getHead(),this.getNext());
        this.setHead(input);
        this.setNext(tmpNewMyList);
    }
    public void pushBot(Element input){
        if(this.isEmpty()){
            this.head=input;
            return;
        }

        MyList tmp = this;
        while (tmp.getNext()!=null)
            tmp = tmp.getNext();
        tmp.setNext(new MyList(input));
    }
    public void clear(){
        this.head=null;
        this.next=null;
    }
    public Element popTop(){
        Element tmp = this.getHead();
        if(this.next==null) {
            this.setHead(null);
            return tmp;
        }
        this.setHead(this.getNext().getHead());
        this.setNext(this.getNext().getNext());
        return tmp;
    }
    public Element popBot(){
        Element output;
        if(this.next==null){
            output = this.getHead();
            this.setHead(null);
            return output;
        }

        MyList tmp = this;
        while (tmp.getNext().getNext()!=null)
            tmp = tmp.getNext();
        output = tmp.getNext().getHead();
        tmp.setNext(null);
        return output;
    }
    public void sout(){
        if(this.head==null)
            return;

        MyList tmp = this;
        while (tmp!=null){
            System.out.println("\t MyList stout: "+tmp.getHead().getIndex());
            tmp=tmp.getNext();
        }

    }

    private Element getHead() {
        return head;
    }

    private void setHead(Element head) {
        this.head = head;
    }

    private MyList getNext() {
        return next;
    }

    private void setNext(MyList next) {
        this.next = next;
    }

    public boolean isEmpty(){
        return this.head==null;
    }

    public boolean isElementInList(Element input){
        MyList tmp = this;
        while(tmp!=null){
            if(tmp.getHead()==input)
                return true;
            tmp = tmp.getNext();
        }
        return false;
    }
    public void clone(MyList input){
        MyList tmpBase = this;
        MyList tmpInput = input;
        tmpBase.setHead(tmpInput.getHead());
        tmpBase.setNext(null);
        tmpInput=tmpInput.getNext();

        while (tmpInput!=null){
            tmpBase.setNext(new MyList(tmpInput.getHead()));
            tmpBase = tmpBase.getNext();
            tmpInput = tmpInput.getNext();
        }

    }


}
