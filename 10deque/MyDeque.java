import java.util.*;

public class MyDeque<T>{

    private int head, tail, size;
    private Object[] que;

    public String name(){
	return "zeng.pingping";
    }

    public MyDeque(){
	que = new Object[10];
	head = 4;
	tail = 5;
	size = 0;
    }

    public void addFirst(T value){
	//resize();
	que[head] = value;
	head--;
	size++;
    }

    public void addLast(T value){
	//resize();
	que[tail] = value;
	tail++;
	size++;
    }

    public T removeFirst(){
	T value = (T)que[head + 1];
	head++;
	size--;
	return value;
    }

    public T removeLast(){
	T value = (T)que[tail - 1];
	tail--;
	size--;
	return value;
    }

    public T getFirst(){
	return (T)que[head + 1];
    }

    public T getLast(){
	return (T)que[tail - 1];
    }

    public void resize(){

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
    }

}
