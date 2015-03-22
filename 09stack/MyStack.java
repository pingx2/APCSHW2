import java.util.*;

public class MyStack<E>{
    
    private LinkedList<E> stack;

    public String name(){
	return "zeng.pingping";
    }

    public MyStack(){
	stack = new LinkedList<E>();
    }

   public E push(E item){
       stack.add(0,item);
       return item;
    }

    public E peek(){
	if(!empty()){
	    return stack.get(0);
	}else{
	    throw new EmptyStackException();
	}
    }

    public E pop(){
	if(!empty()){	    
	    E current = stack.get(0);
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

	a.push("a");
	a.push("b");
	a.push("c");
	a.push("1");
	a.push("2");

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
