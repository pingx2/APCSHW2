import java.util.*;

public class MyDeque<T>{

    private int head, tail, size;
    private Object[] que;
    private int[] p;

    public String name(){
	return "zeng.pingping";
    }

    public MyDeque(){
	this(100);
    }

    public MyDeque(int s){
	que = new Object[s];
	p = new int[s];
	head = s/2 + 1;
	tail = s/2;
	size = 0;
    }

    public void add(T value, int priority){
	addLast(value);
	p[tail] = priority;	
    }

    public T removeSmallest(){
	if(size == 0){
	    throw new NoSuchElementException();
	}
	int min = p[head];
	int index = head;
	if(head < tail){
	    for(int i = head + 1; i <= tail; i++){
		if(p[i] < min){
		    min = p[i];
		    index = i;
		}
	    }
	}else{
	    for(int i = tail; i < que.length; i++){
		if(p[i] < min){
		    min = p[i];
		    index = i;
		}
	    }
	    for(int i = 0; i < head; i++){
		if(p[i] < min){
		    min = p[i];
		    index = i;
		}
	    }
	}
	T value = (T)que[index];
	if(head < tail){
	    for(int i = index - 1; i >= head; i--){
		que[i+1] = que[i];
		p[i+1] = p[i];
	    }
	    head++;
	    if(head == que.length){
		head = 0;
	    }
	}else{
	    for(int i = index + 1; i >= tail; i++){
		que[i-1] = que[i];
		p[i-1] = p[i];
	    }
	    tail--;
	    if(tail < 0){
		tail = que.length-1;
	    }
	}
	size--;
	return value;
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
	    int[] pcopy = new int[p.length * 2];
	    int start = 0;
	    if(head <= tail){
		for(int i = head; i <= tail; i++){
		    copy[start] = que[i];
		    pcopy[start] = p[i];
		    start++;
		}  
	    }else{
		for(int i = head; i < que.length; i++){
		    copy[start] = que[i];
		    pcopy[start] = p[i];
		    start++;
		}
		for(int i = 0; i <= tail; i++){
		    copy[start] = que[i];
		    pcopy[start] = p[i];
		    start++;
		}
	    }
	    head = 0;
	    tail = size - 1;
	    que = copy;
	    p = pcopy;
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

    public static void main(String[]args){
	
	MyDeque q = new MyDeque<String>();

	q.add('A',2);
	q.add('B',0);
	q.add('C',1);
	q.add('D',4);

	System.out.println(q);

	q.removeSmallest();
	System.out.println(q);


    }
    
}
