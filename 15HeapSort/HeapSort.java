import java.util.*;

public class HeapSort{

 
    public static void sort(int[] heap){
	heapify(heap);
	for(int i = heap.length - 1; i >=0; i--){
	    swap(heap,0,i);
	    heapSwap(heap,0,i);
	}
	
    }

   private static void heapify(int[] array){
	for(int i = array.length/2; i >= 0; i--){
	    heapSwap(array, i, array.length);
	}
	System.out.println(Arrays.toString(array));
    }
    
   private static void heapSwap(int[]heap, int index, int end){
       int min = index;
       if(index * 2 < end && (heap[index*2] > heap[index])){
	   min = index * 2;
       }
       if(index * 2 + 1 < end && (heap[index*2+1] > heap[min])){
	   min = index * 2 + 1;
       }
       if(min != index){
	   swap(heap, index, min);
	   heapSwap(heap, min, end);
       }
       
   }
    
    private static void swap(int[] heap, int a, int b){
	int temp = heap[a];
	heap[a] = heap[b];
	heap[b] = temp;
    }
    
    public String name(){
	return "pingping.zeng";
    }
    

    public static void main(String[]args){
	
	int[] array = {3,6,7,2,9,8,1,5,0,4,-3,402};
	sort(array);
	System.out.println(Arrays.toString(array));

    }

}
