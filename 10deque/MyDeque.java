import java.util.*;

public class MyDeque<T>{

    private int head, tail, size;
    private Object[] que;

    public String name(){
	return "zeng.pingping";
    }

    public MyDeque(){
	que = new Object[100];
	head = 49;
	tail = 50;
	size = 0;
    }

    public void addFirst(T value){
	resize();
	if(head < 0){
	    head = que.length - 1;
	}
	que[head] = value;
	head--;
	size++;
    }

    public void addLast(T value){
	resize();
	if(tail >= que.length){
	    tail = 0;
	}
	que[tail] = value;
	tail++;
	size++;
    }

    public T removeFirst(){
	if(size == 0){
	    throw new NoSuchElementException();
	}
	T value = (T)que[head + 1];
	head++;
	size--;
	return value;
    }

    public T removeLast(){
	if(size == 0){
	    throw new NoSuchElementException();
	}
	T value = (T)que[tail - 1];
	tail--;
	size--;
	return value;
    }

    public T getFirst(){
	if(size == 0){
	    throw new NoSuchElementException();
	}
	return (T)que[head + 1];
    }

    public T getLast(){
	if(size == 0){
	    throw new NoSuchElementException();
	}
	return (T)que[tail - 1];
    }

    public void resize(){
	if(size == que.length){
	    Object[] copy = new Object[que.length * 2];
	    int start = copy.length/2 - ((tail - head)/2);
	    if(head < tail){
		for(int i = head; i <= tail; i++){
		    copy[start + i] = que[i];
		}
		head = start;
		tail += start;
	    }else{
		int j = 0;
		for(int i = head; i < que.length; i++){
		    copy[start + j] = que[i];
		    j++;
		}
		for(int i = 0; i <= tail; i++){
		    copy[start + j] = que[i];
		    j++;
		}
		head = start;
		tail = start + que.length;
	    }
	    que = copy;
	}
    }

    public String toString(){
	if(size > 0){
	String result = "[";
	if(head < tail){
	    for(int i = head + 1; i < tail; i++){
		result += que[i] + ", ";
	    }
	}else{
	    for(int i = head + 1; i < que.length-1; i++){
		result += que[i] + ", ";
	    }
	    for(int i = 0; i < tail; i++){
		result += que[i] + ", "; 
	    }
	}
	return result.substring(0,result.length() - 2) + "]";
	}
	return "[]";
    }

    public static void main(String[]args){
	
	MyDeque<Integer> que = new MyDeque<Integer>();

	que.addFirst(1);
	que.addFirst(2);
	que.addFirst(3);
	que.addLast(4);
	que.addLast(5);
	que.addLast(6);
	System.out.println(que.getFirst());
	System.out.println(que);


    }

}
