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
		System.out.println("head" + head);
		System.out.println("tail" + tail);
		int j = 0;
		for(int i = head + 1; i < que.length; i++){
		    copy[start + j] = que[i];
		    j++;
		}
		for(int i = 0; i < head + 1; i++){
		    copy[start + j] = que[i];
		    j++;
		}
		head = start;
		tail = start + que.length;
	    }
	    //System.out.println(head);
	    //System.out.println(tail);
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


    public static void main(String[]args){
	
	MyDeque<Integer> que = new MyDeque<Integer>(5);

	que.addFirst(1);
	que.addFirst(2);
	que.addFirst(3);
	que.addLast(4);
	que.addLast(5);
	que.addLast(6);
	System.out.println(que.getFirst());
	System.out.println(que.getLast());
	System.out.println(que.removeFirst());
	System.out.println(que.removeLast());
	System.out.println(que);


    }

}
