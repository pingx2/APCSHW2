import java.util.*;
import java.io.*;


public class Sorts{

    public static String name(){
	return "zeng.pingping";
    }

    public static int[] merge(int[]array){
	if(array.length == 0 || array.length == 1){
	    return array;
	}
	int[] a = new int[array.length/2];
	int[] b = new int[array.length - array.length/2];
	System.arraycopy(array,0,a,0,array.length/2);
	System.arraycopy(array,array.length/2,b,0,array.length - array.length/2);
	return merge(merge(a),merge(b));

    }


    public static int[] merge(int[] a, int[] b){
	int[] c = new int[a.length+b.length];
	return merge(a,b,c,0,0,0);
    
    }

    
    public static int[] merge(int[] a, int[] b, int[] c, int acount, int bcount, int ccount){
	if(ccount == c.length){
	    return c;
	}
	if(acount == a.length){
	    for(int i = 0; i < b.length - bcount; i++){
		c[ccount+i] = b[bcount+i];
	    }
	    return c;
	}
	if(bcount == b.length){
	    for(int i = 0; i < a.length - acount; i++){
		c[ccount+i] = a[acount+i];
	    }
	    return c;
	}
	if(a[acount] > b[bcount]){
	    c[ccount] = b[bcount];
	    return merge(a,b,c,acount,bcount+1,ccount+1);
	}else{
	    c[ccount] = a[acount];
	    return merge(a,b,c,acount+1,bcount,ccount+1);

	}
	
    }
	
    public static void mergeSort(int[] array){
	int[] copy = new int[array.length];
	copy = merge(array);
	for(int i = 0; i < copy.length; i++){
	    array[i] = copy[i];
	}
    }   

    public static void main(String[]args){

	System.out.println(name());
	
	Random rand = new Random();

	int[] a = new int[10];
	int[] b = new int[10];
	int[] c = new int[10];
	int[] d = {180, -4801, 39001, 49, -43829, 180128, -2, 42811, -314, -94282};

	for(int i = 0; i < a.length; i++){
	    a[i] = i;
	}

	for(int i = 1; i < b.length; i++){
	    b[i] = b.length - i;
	}

	for(int i = 0; i < c.length; i++){
	    c[i] = rand.nextInt(10);
	}

	mergeSort(a);
	System.out.println(Arrays.toString(a));

	mergeSort(b);
	System.out.println(Arrays.toString(b));

	mergeSort(c);
	System.out.println(Arrays.toString(c));

	mergeSort(d);
	System.out.println(Arrays.toString(d));

    }
    
}
