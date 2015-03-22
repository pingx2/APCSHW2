import java.util.*;

public class MyStack<E>{
    
    private LinkedList<E> stack;

    public MyStack(){

    }

    public E peek(){
	return stack.get(0);
    }

    public E pop(){
	E current = stack.get(0);
	stack.remove(0);
	return current;
    }

    public void push(E item){
	stack.add(item);
    }

    public boolean empty(){
	if(stack.size() == 0){
	    return true;
	}
	return false;
    }

}
