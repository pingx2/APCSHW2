public class Recursion{

    public String name(){
	return "Zeng,PingPing";
    }

    public int fact(int n){
	if(n<0){
	    throw new IllegalArgumentException();
	}
	if(n==0){
	    return 1;
	}else{
	    return n*fact(n-1);
	}
    }

    public int fib(int n){
	if(n<0){
	    throw new IllegalArgumentException();
	}
	if(n==0){
	    return 0;
	}
	if(n==1){
	    return 1;
	}else{
	    return fib(n-1)+fib(n-2);
	}
    }
   
    public double sqrt(double n){
	if(n<0){
	    throw new IllegalArgumentException();
	}
	return sqrthelper(n, 1.0);
    }

    public double sqrthelper(double n, double guess){
	if(n==0){
	    return 0;
	}
	if(Math.abs(guess*guess - n)<.0000000001){
	    return guess;
	}else{
	    return sqrthelper(n, (n/guess+guess)/2);
	}

    }
    
    
    
    /*  
    public static void main(String[]args){
	
	Recursion a = new Recursion();
	
	System.out.println(a.name());
      	System.out.println(a.fact(0));
	System.out.println(a.fact(1));
	System.out.println(a.fact(5));
	//System.out.println(a.fact(-1));
	System.out.println(a.fib(0));
	System.out.println(a.fib(2));
        System.out.println(a.fib(5));
	System.out.println(a.fib(10));
	//System.out.println(a.fib(-1));
	System.out.println(a.sqrt(169.0));
	System.out.println(a.sqrt(1.0));
	System.out.println(a.sqrt(0.000000001));
	System.out.println(a.sqrt(0.0));
	//System.out.println(a.sqrt(-100.00));
    
    }
    
    */
    
}

	

