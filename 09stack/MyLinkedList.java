import java.util.*;

public class MyLinkedList<T> implements Iterable<T>{

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
	if(index == 0){
	    LNode<T> next = new LNode<T>(n,start);
	    start = next;
	    size++;
	}else{
	    LNode<T> current = start;
	    for(int i = 0; i < index - 1; i++){
	    current = current.getNext();
	    }
	    LNode<T> next = new LNode<T>(n,current.getNext());
	    current.setNext(next);
	    size++;
	}
    
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


   private class MyLLIterator implements Iterator<T>{
       
       private LNode<T> current;

       public MyLLIterator(){
	   current = start;
       }

       public T next(){
	   T temp = current.getData();
	   current = current.getNext();
	   if(temp != null){
	       return temp;
	   }else{
	       throw new NoSuchElementException();
	   }
       }
       
       public boolean hasNext(){
	   if(current != null){
	       return true;
	   }else{
	       return false;
	   }
       }

       public void remove(){
	   throw new UnsupportedOperationException();
       }
   }
   
   public Iterator<T> iterator(){
       return new MyLLIterator();
   }
   
    public static void main(String[]arg){
	
	
	MyLinkedList<Integer> a = new MyLinkedList<Integer>();

	System.out.println(a.name());
	a.add(1);
	a.add(2);
	a.add(3);
	a.add(0,6);
	a.add(0,5);
	a.add(0,4);
	System.out.println(a.get(0));



	/*
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
	System.out.println(a);
	
	for(int i : a){
	    System.out.println(i);
	}
	*/

    }
}
