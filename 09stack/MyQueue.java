import java.util.*;

public class MyQueue<T>{

    private MyLinkedList<T> stack;

    public String name(){
	return "zeng.pingping";
    }
    
    public MyQueue(){
	stack = new MyLinkedList<T>();
    }

    public boolean enqueue(T item){
	stack.add(item);
	return true;
    }

    public T dequeue(){
	T current = stack.get(0);
	stack.remove(0);
	return current;
    }

    public static void main(String[]args){

	MyQueue<Integer> a = new MyQueue<Integer>();
	
	a.enqueue(1);
	a.enqueue(2);
	a.enqueue(3);
	
	System.out.println(a.dequeue());
	System.out.println(a.dequeue());
	System.out.println(a.dequeue());

    }
}
