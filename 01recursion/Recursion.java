public class Recursion implements hw1{

    public String name(){
	return "Zeng, Ping Ping";
    }

    public int fact(int n){
	if(n<0){
	    throw new IllegalArgumentException();
	}
	if(n==1){
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
	double guess = 1.0;
	return sqrthelper(n, guess);
    }

    public double sqrthelper(double n, double guess){
	if(guess*guess == n){
	    return guess;
	}else{
	    return sqrthelper(n, (n/guess+guess)/2);
	}

    }

    /*
      public static void main(String[]args){
      
      Recursion a = new Recursion();
      
      System.out.println(a.fact(3));
      System.out.println(a.fact(5));
      System.out.println(a.fib(3));
      System.out.println(a.fib(5));
      System.out.println(a.fib(9));
      System.out.println(a.sqrt(49));
      System.out.println(a.sqrt(100));
      System.out.println(a.sqrt(143));
      }
    */
    
}

	

