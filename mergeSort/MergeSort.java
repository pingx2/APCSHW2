public class MergeSort{

    public void merge(int[]a, int[]b){
	int[] merged = new int[a.length+b.length]; 
	int acount = 0;
	int bcount = 0;
	for(int i = 0; i < merged.length; i++){
	    if(acount < a.length && bcount < b.length){
		if(a[acount] >= b[bcount]){
		    merged[i] = b[acount];
		    bcount++;
		}
		else if(a[acount] < b[bcount]){
		    merged[i] = a[acount];
		    acount++;
		}
	    }else{
		if(acount == a.length){
		    merged[i] = b[bcount];
		    bcount++;
		}
		else if(bcount == b.length){
		    merged[i] = a[acount];
		    acount++;
		}
	    }
	}
    }
}
