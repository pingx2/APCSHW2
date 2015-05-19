import java.util.*;

public class HeapSort{

    private static void heapify(int[] array){
	for(int i = array.length; i >= 0; i--){
	    removeSwap(array, i);
	}
    }

 
    public static void sort(int[] heap){
	heapify(heap);
	int value = heap[1];
	heap[1] = heap[heap[0]];
	heap[0] -= 1;
	removeSwap(1);
	return value;
    }
    
    private static void removeSwap(int[]heap, int index){
	if(index*2 - 1 < heap.length && (heap[index] > heap[index*2] ||
					 heap[index] > heap[index*2+1])){
	    //int temp = heap[index];
	    if(heap[index*2] > heap[index*2+1]){
		swap(heap, index, index*2+1);
		//heap[index] = heap[index*2+1];
		//heap[index*2+1] = temp;
		removeSwap(index*2+1);
	    }else{
		swap(heap, index, index*2);
		//heap[index] = heap[index*2];
		//heap[index*2] = temp;
		removeSwap(index*2);
	    }
	}
    }
    
   private static void swap(int[] heap, int a, int b){
	int temp = heap[a];
	heap[a] = heap[b];
	heap[b] = temp;
    }
    

}
