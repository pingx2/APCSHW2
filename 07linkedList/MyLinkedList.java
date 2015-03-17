public class MyLinkedList<T>{

    private LNode<T> start;
    private LNode<T> end;
    private int size;

   public String name(){
	return "zeng.pingping";
    }

    public MyLinkedList(){
	size = 0;
    }

    public void set(int index, T n){
	if(index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException();
	}
	LNode<T> current = start;
	for(int i = 0; i < index; i++){
	    current = current.getNext();
	}
	current.setData(n);
    }

    public T get(int index){
	if(index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException();
	}
	LNode<T> current = start;
	for(int i = 0; i < index; i++){
	    current = current.getNext();
	}
	return current.getData();
    }

    public boolean add(T n){
	if(size() == 0){
	    start = new LNode<T>(n);
	    end = start;
	}else{
	    LNode<T> next = new LNode<T>(n);
	    end.setNext(next);
	    end = next;
	    /*
	    LNode current = start;
	    for(int i = 0; i < size() - 1; i++){
		current = current.getNext();
	    }
	    LNode next = new LNode(n);
	    current.setNext(next);
	    */
	}
	size++;
	return true;
    }

    public void add(int index, T n){
	if(index < 0 || index > size()){
	    throw new IndexOutOfBoundsException();
	}
	LNode<T> current = start;
	for(int i = 0; i < index - 1; i++){
	    current = current.getNext();
	}
	LNode<T> next = new LNode<T>(n,current.getNext());
	current.setNext(next);
	size++;
    }
    
    public boolean remove(int index){
	if(index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException();
	}
	LNode<T> current = start;
	for(int i = 0; i < index; i++){
	    current = current.getNext();
	}
	for(int i = index; i < size() - 1; i++){
	    LNode<T> next = current.getNext();
	    current.setData(next.getData()); 
	    current = current.getNext(); 
	}
	size--;
	return true;
    }
    
    public int indexOf(T n){
	LNode<T> current = start;
	for(int i = 0; i < size(); i++){
	    if(current.getData().equals(n)){
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

   public String toString(){
	String result = "[";
	LNode current = start;
	for(int i = 0; i < size(); i++){
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
	
	
	MyLinkedList<Integer> a = new MyLinkedList<Integer>();

	System.out.println(a.name());
	a.add(1);
	a.add(2);
	a.add(3);
	System.out.println(a);
	a.set(1,4);
	System.out.println(a);
	System.out.println(a.get(1));
	System.out.println(a.indexOf(4));
	System.out.println(a.size());
	a.add(2,6);
	System.out.println(a);
	a.remove(1);
	a.remove(1);
	//a.remove(5);
	a.remove(0);
	a.remove(0);
	System.out.println(a);
	a.add(1);
	a.add(3);
	a.add(2,4);
	//a.add(5,2);
	a.set(1,3);
	//System.out.println(a.indexOf(10));
	System.out.println(a);


	MyLinkedList<String> b = new MyLinkedList<String>();

	b.add("H");
	b.add("I");
	System.out.println(b);
	b.remove(0);
	b.remove(0);
	System.out.println(b);
	b.add("H");
	b.add("I");
	b.add("!");
	b.set(1,"i");
	System.out.println(b.get(1));
	System.out.println(b.indexOf("I"));
	System.out.println(b.size());
	System.out.println(b);

    }
}
