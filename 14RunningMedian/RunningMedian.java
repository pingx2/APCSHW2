import java.util.*;

public class RunningMedian{

    private MyHeap max, min;
    private int median;

    public RunningMedian(){
	max = new MyHeap();
	min = new MyHeap(false);
    }

    public void add(int value){
	if(getMedian() < value){
	    min.add(value);
	}else if(getMedian() > value){
	    max.add(value);
	    
	    
    }

    public double getMedian(){
	if(max.size() == min.size()){
	    return (max.peek() + min.peek()) / 2;
	}else if(max.size() > min.size()){
	    return max.peek();
	}else if(min.size() > max.size()){
	    return min.peek();
	}
    }
	 

}
