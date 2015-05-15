import java.util.*;

public class RunningMedian{

    MyHeap min, max;
    int current;

    public RunningMedian(){
	max = new MyHeap();
	min = new MyHeap(false);
        current = new ArrayList<Integer>();
    }

    public void add(int value){
	if(max.size() == 0 && min.size() == 0){
	    current = value;
	}else if(max.peek() > value){
	    
	    
	    
    }

    public double getMedian(){
	return 0.0;
    }

}