public class MyLinkedList{

    private LNode start;
    private int size;

    public MyLinkedList(){
	start = new LNode(0);
	size = 0;
    }

    /*
    public MyLinkedList(LNode n){
	start = n;
	size = 0;
    }
    */

    public void set(int index, int n){
	if(index >= 0 && index < size){
	    LNode current = start;
	    for(int i = 0; i < index; i++){
		current = current.getNext();
	    }
	    current.setData(n);
	}
    }

    public int get(int index){
	if(index >= 0 && index < size){
	    LNode current = start;
	    for(int i = 0; i < index; i++){
		current = current.getNext();
	    }
	    return current.getData();
	}
	//fix
	return -1;
    }

    public boolean add(int n){
	if(size == 0){
	    start = new LNode(n);
	}else{
	    LNode current = start;
	    for(int i = 0; i < size - 1; i++){
		current = current.getNext();
	    }
	    LNode next = new LNode(n);
	    current.setNext(next);
	}
	size++;
	return true;
    }

    public void add(int index, int n){
	if(index >= 0 && index <= size){
	    if(index == size){
		add(n);
	    }else{
		LNode current = start;
		for(int i = 0; i < index - 1; i++){
		    current = current.getNext();
		}
		LNode next = new LNode(n,current.getNext());
		current.setNext(next);
		size++;
		return true;
	    }
	}
    }

    public int indexOf(int n){
	LNode current = start;
	for(int i = 0; i < size; i++){
	    if(current.getData() == n){
		return i;
	    }else{
		current = current.getNext();
	    }
	}
	return -1;
    } 

    public int size(){
	return size;
    }

    /*
    public int size(){
	int s = 0;
	LNode current = start;
	while(current != null){
	    s++;
	    current = current.getNext();
	}
	return s;
    }
    */

    public int remove(int i){

    }

    public void clear(){

    }

   public String toString(){
	String result = "[";
	LNode current = start;
	for(int i = 0; i < size; i++){
	    result += current.toString();
	    if(i != size - 1){
		result += ", ";
	    }
	    current = current.getNext();
	}
	result += "]";
	return result;
    }

    public static void main(String[]arg){
	
	MyLinkedList a = new MyLinkedList();

	a.add(1);
	a.add(2);
	a.add(3);
	a.set(1,4);
	System.out.println(a.get(1));
	System.out.println(a.indexOf(4));
	System.out.println(a.size());

	a.add(2,6);

	System.out.println(a);

    }
}
