public class Sorts{

    public void mergesort(int[] a, int[]b, int[]c){

    }

    public void merge(int[] a, int[] b, int acount, int bcount){
	int[] merged = new int[a.length+b.length]; 
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

    public void sort(int[] a){

    }


}
