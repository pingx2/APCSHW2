import java.util.*;

public class MyHeap{

    private int[] heap;
    private boolean isMax;

    public MyHeap(){
	this(true);
    }

    public MyHeap(boolean m){
	heap = new int[10];
	isMax = m;
    }

    public void add(int value){
	heap[heap[0]+1] = value;
 	heap[0] += 1;
	swap(heap[0]); 
      	resize();
    }

    private void swap(int index){
	if(index != 1 && compare(heap[index/2],heap[index])){
	    int temp = heap[index];
	    data[index] = data[index/2];
	    data[index/2] = temp;
	    swap(index/2);
	}
    }
    

    private boolean compare(int parent, int child){
	if(isMax){
	    return parent < child;
	}else{
	    return parent > child;
	}
    }
    
    public int remove(){
	if(heap
	int value = heap[1];
	heap[1] = heap[heap[0]];
	heap[heap[0]] = 0;
	heap[0] -= 1;
	swap(heap[1]);
	return value;
    }

    public int peek(){
	if(heap[0] == 0){
	    throw new NoSuchElementException();
	}
	return heap[1];
    }

    public void resize(){

    }
    
    public String toString(){
	return "";
    }
    
    public String name(){
	return "pingping.zeng";
    }
		   
}
