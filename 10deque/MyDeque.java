import java.util.*;

public class MyDeque<T>{

    private int head, tail, size;
    private T[] que;

    public String name(){
	return "zeng.pingping";
    }

    public MyDeque(){
	que = new T[10];
	head = 4;
	tail = 5;
	size = 0;
    }

    public void addFirst(T value){
	resize();
	que[head] = value;
	head--;
	size++;
    }

    public void addLast(T value){
	resize();
	que[tail] = value;
	tail++;
	size++;
    }

    public T removeFirst(){
	T res = que[head + 1];
	head++;
	size--;
    }

    public T removeLast(){
	T res = que[tail - 1];
	tail--;
	size--;
    }

    public T getFirst(){

    }

    public T getLast(){

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
    }

}
