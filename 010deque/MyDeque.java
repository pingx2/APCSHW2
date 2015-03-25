import java.util.*;

public class MyDeque<T>{

    private int head, tail, size;
    private T[] que;

    public String name(){
	return "zeng.pingping";
    }

    public MyDeque{
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

    }

    public T removeFirst(){

    }

    public T removeLast(){

    }

    public T getFirst(){

    }

    public T getLast(){

    }

    public void resize(){

    }

}
