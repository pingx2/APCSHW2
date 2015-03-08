import java.util.*;

public class QuickSelect{

    private static Random r = new Random();
  
    public static int quickSelect(int[] ary, int n){
	if(n <= 0 || n > ary.length){
	    throw new IndexOutOfBoundsException();
	}
	return partition(ary,0,ary.length-1,n); 
    }

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
    
  

    public static void main(String[]args){
	
	int[]ary = {9,5,1,8,3,4,7,2,6,0};
	
	/*
	for(int i = 0; i < ary.length; i++){
	    System.out.print(ary[i]+" ");
	}
	
	System.out.println();

	partition(ary,0,9);

	*/
	System.out.println(Arrays.toString(ary));
	System.out.println(quickSelect(ary,5));
   
	
    }
}  
