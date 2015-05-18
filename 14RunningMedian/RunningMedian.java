import java.util.*;

public class RunningMedian{

    public MyHeap max, min;

    public RunningMedian(){
	max = new MyHeap();
	min = new MyHeap(false);
    }

    public void add(int value){
	if(max.size() == 0 && min.size() == 0){
	    max.add(value);
	}else if(value < getMedian()){
	    max.add(value);
	}else{
	    min.add(value);
	}
	if(max.size() - min.size() > 1){
	    min.add(max.remove());
	}
	if(min.size() - max.size() > 1){
	    max.add(min.remove());
	}
	
    }
    
    public double getMedian(){
	if(max.size() > min.size()){
	    return max.peek();
	}else if(max.size() < min.size()){
	    return min.peek();
	}else{
	    return (max.peek() + min.peek()) / 2.0;
	}
    }

    public String name(){
	return "pingping.zeng";
    }
	 
    public static void main(String[]args){
	
	RunningMedian m = new RunningMedian();

	m.add(20);

	m.add(-3);
	m.add(-1);
	m.add(5);
	m.add(6);
	m.add(7);
	m.add(8);
	m.add(9);
	m.add(10);
	m.add(11);
	m.add(12);
	//m.add(14);


	System.out.println(m.min.toString());
	System.out.println(m.max.toString());

	System.out.println(m.getMedian());
    
    }



}
