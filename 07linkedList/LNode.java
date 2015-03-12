public class LNode{

    private int data;
    private LNode next;

    public LNode(int d){
	data = d;
    }

    public LNode(int d, LNode n){
	data = d;
	next = n;
    }

    public void setData(int d){
	data = d;
    }

    public int getData(){
	return data;
    }

    public void setNext(LNode n){
	next = n;
    }

    public LNode getNext(){
	return next;
    }

    public String toString(){
	return "" + data;
    }

}
