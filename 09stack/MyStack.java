import java.util.*;

public class MyStack<T>{
    
    private MyLinkedList<T> stack;

    public String name(){
	return "zeng.pingping";
    }

    public MyStack(){
	stack = new MyLinkedList<T>();
    }

   public T push(T item){
       stack.add(0,item);
       return item;
    }

    public T peek(){
	if(!empty()){
	    return stack.get(0);
	}else{
	    throw new EmptyStackException();
	}
    }

    public T pop(){
	if(!empty()){	    
	    T current = stack.get(0);
	    stack.remove(0);
	    return current;
	}else{
	    throw new EmptyStackException();
	}
    }

    public boolean empty(){
	return (stack.size() == 0);
    }

    public static void main(String[]args){
	
	MyStack<String> a = new MyStack<String>();

	System.out.println(a.push("a"));
	System.out.println(a.push("b"));
	System.out.println(a.push("c"));
	System.out.println(a.push("1"));
	System.out.println(a.push("2"));
	System.out.println(a.push("3"));

	System.out.println(a.peek());
	System.out.println(a.pop());
	System.out.println(a.pop());
	System.out.println(a.peek());

	System.out.println(a.pop());
	System.out.println(a.pop());
	System.out.println(a.pop());
	
	a.push("1");
	a.push("2");	

	System.out.println(a.peek());

	//System.out.println(a.pop());
	//System.out.println(a.peek());
	



    }

}
