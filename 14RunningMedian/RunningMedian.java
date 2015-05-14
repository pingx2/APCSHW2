import java.util.*;

public class RunningMedian{

    MyHeap min, max;
    ArrayList<Integer> current;

    public RunningMedian(){
	max = new MyHeap();
	min = new MyHeap(false);
        current = new ArrayList<Integer>();
    }

    public void add(int value){
	current.add(value);
	if(current.size() == 3){
	    if( max.peek() > value){
	    
	    
    }

    public double getMedian(){
	return 0.0;
    }

}