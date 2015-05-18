import java.util.*;

public class MyHeap{

    private int[] heap;
    private boolean isMax;

    public MyHeap(){
	this(true);
    }

    public MyHeap(boolean m){
	heap = new int[10];
	heap[0] = 0;
	isMax = m;
    }

    public void add(int value){
	heap[heap[0]+1] = value;
 	heap[0] += 1;
	addSwap(heap[0]); 
      	resize();
    }

    private void addSwap(int index){
	if(index != 1 && compare(heap[index/2],heap[index])){
	    int temp = heap[index];
	    heap[index] = heap[index/2];
	    heap[index/2] = temp;
	    addSwap(index/2);
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
	if(heap[0] == 0){
	    throw new NoSuchElementException();
	}
	int value = heap[1];
	heap[1] = heap[heap[0]];
	heap[0] -= 1;
	removeSwap(1);
	return value;
    }

    private void removeSwap(int index){
	if(index*2 - 1 < heap[0] && (compare(heap[index],heap[index*2]) ||
			       compare(heap[index],heap[index*2+1]))){
	    int temp = heap[index];
	    if(compare(heap[index*2],heap[index*2+1])){
		heap[index] = heap[index*2+1];
		heap[index*2+1] = temp;
		removeSwap(index*2+1);
	    }else{
		heap[index] = heap[index*2];
		heap[index*2] = temp;
		removeSwap(index*2);
	    }
	}
    }

    public int peek(){
	if(heap[0] == 0){
	    throw new NoSuchElementException();
	}
	return heap[1];
    }

    public int size(){
	return heap[0];
    }

    public void resize(){
	if(heap[0] == heap.length - 1){
	    heap = Arrays.copyOf(heap, heap[0] * 2);
	}
    }
    
    private int getHeight(){
	int height = 0;
	int n = heap[0];
	while(n != 0){
	    n = n/2;
	    height++;
	}
	return height;
    }

    public String toString(){
	String res = "";
	for(int i = 1; i <= heap[0]; i++){
	    res += heap[i] + " ";
	    
	}
	return res;
    }
    
    public String name(){
	return "pingping.zeng";
    }
		   
    public static void main(String[]args){
	
	MyHeap h = new MyHeap(false);

	h.add(20);

	h.add(9);
	h.add(10);
	h.add(8);
	h.add(11);
	h.add(12);

	System.out.println(h);

	

	//h.remove();


	//System.out.println(h.remove());


	//System.out.println(h);
    

    }

}
