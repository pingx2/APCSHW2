import java.util.*;

public class MyDeque<T>{
    private int head, tail, size;
    private Object[] que;
    public String name(){
	return "zeng.pingping";
    }
    public MyDeque(){
	this(100);
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
	size--;
	return value;
    }
    public T removeLast(){
	if(size == 0){
	    throw new NoSuchElementException();
	}
	T value = (T)que[tail];
	tail--;
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
    public void resize(){
	if(size == que.length){
	    Object[] copy = new Object[que.length * 2];
	    int start = copy.length/2 - (size/2);
	    if(head < tail){
		for(int i = head; i <= tail; i++){
		    copy[start + i] = que[i];
		}
		head = start;
		tail += start;
	    }else{
		for(int i = head; i < que.length; i++){
		    copy[start + i] = que[i];
		}
		for(int i = 0; i <= tail; i++){
		    copy[start + que.length - head] = que[i];
		}
		head = start;
		tail = start + que.length;
	    }

	    que = copy;
	}
    }
    public String toString(){
	String result = "[";
	if(size > 0){
	    if(head < tail){
		for(int i = head; i <= tail; i++){
		    result += que[i] + ", ";
		}
	    }else{
		for(int i = head + 1; i < que.length; i++){
		    result += que[i] + ", ";
		}
		for(int i = 0; i < head + 1; i++){
		    result += que[i] + ", ";
		}
	    }
	    result = result.substring(0,result.length() - 2);
	}
	return result + "]";
    }
 
}