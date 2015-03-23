import java.util.*;

public class MyQueue{

    private MyLinkedList<T> stack;

    public String name(){
	return "zeng.pingping";
    }
    
    public T enqueue(T item){
	stack.add(0,item);
	return item;
    }

    public T dequeue(){
	if(stack.size()!=0){
	    stack.remove(size()-1);
	    
    }