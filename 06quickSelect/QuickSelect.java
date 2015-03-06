import java.util.*;

public class QuickSelect{

    static Random r = new Random();

    public static void partition(int[] ary, int si, int ei){
	//make a new empty array of the same size as ary
	int[] d = new int[ary.length];
	//copy all elements not in range si to ei over to empty array
	for(int i = 0; i < si; i++){
	    d[i] = ary[i];
	}
	for(int i = ei; i < ary.length; i++){
	    d[i] = ary[i];
	}
	//select a random pivot element
	int num = si + r.nextInt(ei-si+1);
	System.out.println(ary[num]);
	//add the rest of the elements into the new array
	int s = si;
	int e = ei;
	for(int i = si; i <= ei; i++){
	    //if it's less than the pivot value, copy to pos si and increment si
	    if(ary[i] < ary[num]){
		d[s] = ary[i];
		s++;
	    }
	    //if it's greater than the pivot value, copy to pos ei and decrement ei
	    if(ary[i] > ary[num]){
		d[e] = ary[i];
		e--;
	    }
	}
	//copy the pivot value to the new array
	d[s] = ary[num];
   
	for(int i = 0; i < d.length; i++){
	    System.out.print(d[i]+" ");

	}
    }
    
    
    public static void main(String[]args){
	
	int[]ary = {9,5,1,8,3,4,7,2,6,0};
	
	for(int i = 0; i < ary.length; i++){
	    System.out.print(ary[i]+" ");
	}
	
	System.out.println();

	partition(ary,0,9);

	

   
	
    }
}  
