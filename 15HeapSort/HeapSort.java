public class HeapSort{

    public static void sort(int[] heap){
	if(heap[0] == 0){
	    throw new NoSuchElementException();
	}
	int value = heap[1];
	heap[1] = heap[heap[0]];
	heap[heap[0]] = value;
	heap[0] -= 1;
	swap(1);

    }


    public static boolean compare(int a, int b){

    }

    private void swap(int index){

    }

}
