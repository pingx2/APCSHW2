import java.util.*;

public class QuickSort{

    private static Random r = new Random();
  
    public static int quickSelect(int[] ary, int n){
	if(n <= 0 || n > ary.length){
	    throw new IndexOutOfBoundsException();
	}
	return partition(ary,0,ary.length-1,n); 
    }

     public static int findpartition(int[] ary){
	 //pick three random elements and pick the median
	 
     }

    //make in place
    public static int partition(int[] ary, int si, int ei, int n){
	int[] d = new int[ary.length];
	for(int i = 0; i < si; i++){
	    d[i] = ary[i];
	}
	for(int i = ei; i < ary.length; i++){
	    d[i] = ary[i];
	}
	int pi = si + r.nextInt(ei-si+1);
	int s = si;
	int e = ei;
	for(int i = s; i <= e; i++){
	    if(ary[i] < ary[pi]){
		d[si] = ary[i];
		si++;
	    }
	    if(ary[i] > ary[pi]){
		d[ei] = ary[i];
		ei--;
	    }
	}
	d[si] = ary[pi];

	//System.out.println(Arrays.toString(d));

	
	if(si == n - 1){
	    return d[si];
	}

	if(si < n - 1){
	    return partition(d,si+1,e,n);
	}else{
	    //(si > n - 1){
	    return partition(d,s,si-1,n);
	}
	
    }
    
    public static void quickSort(int[] a){
	int pi = findpartition(a);
    	int s = 
	a[pi] = 
	a[a.length-1] = pi;




	
    }
}
