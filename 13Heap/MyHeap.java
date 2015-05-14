import java.util.*;

public class MyHeap{

    private int[] heap;
    private boolean isMax = true;

    public MyHeap(){
	heap = new int[10];
	
    }

    public MyHeap(boolean m){
	heap = new int[10];
	isMax = m;
    }

    public void add(int n){
	resize();
	if(heap[0] == 0){
	    heap[1] = n;
	    heap[0] = 1;
	}else{
	    heap[heap[0]+1] = n;
	    heap[0] = heap[0] + 1;
	}
	//push value up
	for(int i = heap[heap[0]]; i < 0; i/2){
	    if(compare(
    }
    
    public int remove(){
	int val = heap[1];
	heap[1] = heap[heap[0]];
	heap[heap[0]] = 0;
	heap[0] = heap[0] - 1;

	//push value down
	return val;
    }

    private boolean compare(int a, int b){
	if(isMax){
	
	}else{

	}
   
	return false;
    }

    public int peek(){
	return heap[1];
    }

    public void resize(){

    }

    private String getLevel(){

    }

    public String toString(){
	return "";
    }

}
