import java.util.*;
import java.io.*;


public class KnightsTour{
    final static String clear =  "\033[2J";
    final static String hide =  "\033[?25l";
    final static String show =  "\033[?25h";
    
    private int[][]board;
    
    private String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }
 
    public void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }
    
    public String name(){
	return "zeng.pingping";
    }
    
    public String toString(){
	String ans = "\n";
	for(int i = 0; i < board.length; i++){
	    for(int j = 0; j < board[i].length; j++){
		int value = board[i][j];
		if(value < 10){
		    ans+=" ";
		}
		if(value < 100){
		    ans+=" ";
		}
		ans+=board[i][j];
	    }
	    ans+="\n";	
	}
	return hide + clear + go(0,0) + ans + "\n" + show;
    }
    
    public KnightsTour(int size){
	board = new int[size][size];
	for(int i = 0; i < board.length; i++){
	    for(int j = 0; j < board[i].length; j++){
		board[i][j]=0;
	    }
	}	
    }
    
    
    public boolean solve(){
	return solve(0,0);
    }

    public boolean solve(int x, int y){
	return solve(x,y,1);
    }
		
    public boolean solve(int x,int y,int currentMoveNumber){
	//System.out.println(this);
	//wait(10);
	if(x < 0 || x >= board.length || y < 0 || y >= board.length){
	    return false;
	}
	if(board[x][y]==0){
	    if(currentMoveNumber == board.length*board.length){
		board[x][y] = currentMoveNumber;
		return true;
	    }
	    board[x][y] = currentMoveNumber;
	    if(solve(x+1,y+2,currentMoveNumber+1) || 
	       solve(x-1,y+2,currentMoveNumber+1) || 
	       solve(x+1,y-2,currentMoveNumber+1) ||
	       solve(x-1,y-2,currentMoveNumber+1) ||
	       solve(x+2,y+1,currentMoveNumber+1) ||
	       solve(x-2,y+1,currentMoveNumber+1) ||
	       solve(x+2,y-1,currentMoveNumber+1) ||
	       solve(x-2,y-1,currentMoveNumber+1)){
		return true;
	    }
	    board[x][y]=0;
	}
	return false;
    }
    
    public static void main(String[]args){
	KnightsTour a = new KnightsTour(Integer.parseInt(args[0]));
	
	if(a.solve()){
	    System.out.println(a);
	}else{
	    System.out.println("No Solution");

	}
    }

}
