import java.util.*;

public class Sorts{

    private static Random r = new Random();

    public static void quickSort(int[] ary){
	quickSort(ary,0,ary.length-1);
    }

    public static void quickSort(int[] ary, int si, int ei){
	if(si < ei){
	    int pi = partition(ary,si,ei);
	    quickSort(ary,si,pi-1);
	    quickSort(ary,pi+1,ei);
	}
    }
    

    public static int partition(int[] ary, int si, int ei){
	int pi = si + r.nextInt(ei-si+1);
	int pivot = ary[pi];

	//System.out.println(pi);
	//System.out.println(pivot);

	ary[pi] = ary[ei];
	ary[ei] = pivot;

	int s = si;
	int e = ei-1;
	int temp;

	//System.out.println(Arrays.toString(ary));

	while(s <= e){
	    if(ary[s] < pivot){
		s++;
	    }else if(ary[s] > pivot){
		temp = ary[s];
		ary[s] = ary[e];
		ary[e] = temp;
		e--;
	    }else if(ary[s] == pivot){
		temp = ary[s];
		ary[s] = ary[s+1];
		ary[s+1] = temp;
		if(ary[s] == pivot){
		    s++;
		}
	    }
	}

	//System.out.println(Arrays.toString(ary));	

	//System.out.println(s);
	//System.out.println(e);
	//System.out.println(pi);
       	
      
	ary[ei] = ary[s];
        ary[s] = pivot;   

	//System.out.println(Arrays.toString(ary));

	return s;
    }
	
    
    
    public static void main(String[]args){
	
	int[] ary = new int[15];
	for (int i = 0; i < ary.length; i++) {
	    ary[i] = r.nextInt(100);
	}
	System.out.println(Arrays.toString(ary));

	quickSort(ary);

	System.out.println(Arrays.toString(ary));
	
	
    }
}  
