import java.util.*;

public class MyDeque<T>{

    private int head, tail, size;
    private Object[] que;

    public String name(){
	return "zeng.pingping";
    }

    public MyDeque(){
	this(10);
    }

    public MyDeque(int s){
	que = new Object[s];
	head = s/2 + 1;
	tail = s/2;
	size = 0;
    }

    public void addFirst(T value){
	resize();
	head--;
	if(head < 0){
	    head = que.length - 1;
	}
	que[head] = value;
	size++;
    }

    public void addLast(T value){
	resize();
	tail++;
	if(tail >= que.length){
	    tail = 0;
	}
	que[tail] = value;
	size++;
    }

    public T removeFirst(){
	if(size == 0){
	    throw new NoSuchElementException();
	}
	T value = (T)que[head];
	head++;
	if(head >= que.length){
	    head = 0;
	}
	size--;
	return value;
    }
    public T removeLast(){
	if(size == 0){
	    throw new NoSuchElementException();
	}
	T value = (T)que[tail];
	tail--;
	if(tail < 0){
	    tail = que.length - 1;
	}
	size--;
	return value;
    }

    public T getFirst(){
	if(size == 0){
	    throw new NoSuchElementException();
	}
	return (T)que[head];
    }

    public T getLast(){
	if(size == 0){
	    throw new NoSuchElementException();
	}
	return (T)que[tail];
    }

    public int size(){
	return size;
    }

    public void resize(){
	if(size == que.length){
	    Object[] copy = new Object[que.length * 2];
	    int start = 0;
	    if(head <= tail){
		for(int i = head; i <= tail; i++){
		    copy[start] = que[i];
		    start++;
		}  
	    }else{
		for(int i = head; i < que.length; i++){
		    copy[start] = que[i];
		    start++;
		}
		for(int i = 0; i <= tail; i++){
		    copy[start] = que[i];
		    start++;
		}
	    }
	    head = 0;
	    tail = size - 1;
	    que = copy;
	}
    }
    
    public String toString(){
	String result = "[";
	if(size > 0){
	    if(head <= tail){
		for(int i = head; i <= tail; i++){
		    result += que[i] + ", ";
		}
	    }else{
		for(int i = head; i < que.length; i++){
		    result += que[i] + ", ";
		}
		for(int i = 0; i <= tail; i++){
		    result += que[i] + ", ";
		}
	    }
	    result = result.substring(0,result.length() - 2);
	}
	return result + "]";
    }

 
    
}
