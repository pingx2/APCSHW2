import java.util.*;
import java.io.*;


public class NQueens{

    final static String clear =  "\033[2J";
    final static String hide =  "\033[?25l";
    final static String show =  "\033[?25h";
    
    private char[][]board;
    
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
		ans+=board[i][j];
	    }
	    ans+="\n";
	}
	return hide + clear + go(0,0) + ans + "\n" + show;
    }

    public NQueens(int size){
	board = new char[size][size];
	for(int i = 0; i < size; i++){
	    for(int j = 0; j < size; j++){
		board[i][j] = '-';
	    }
	}
    }

    public boolean solve(){
	return solve(0);
    }

    public boolean solve(int x){
	return solve(x,0);
    }

    public boolean check(int x, int y){
	for(int i = 0; i < board.length; i++){
	    for(int j = 0; j < board.length; j++){
		if(board[i][j]=='Q'){
		    //horizontal
		    if(i == y){
			return false;
		    }
		    //vertical
		    if(j == x){
			return false;
		    }
		    //diagonal
		    if(Math.abs(i-y) == Math.abs(j-x)){
			return false;
		    }
		}
	    }
	}
	return true;
    }
    	

    public boolean solve(int x, int y){
	//System.out.println(this);
	//wait(10);
	if(x >= board.length){
	    return true;
	}
	for(int i = 0; i < board.length; i++){
	    if(check(x,i)){
		board[i][x] = 'Q';
		if(solve(x+1,y)){
		    return true;
		}
		board[i][x] = '-';
	    }
	}
	return false;
    }

   
    public static void main(String[]args){
	NQueens a = new NQueens(Integer.parseInt(args[0]));
	
	if(a.solve()){
	    System.out.println(a);
	}else{
	    System.out.println("No Solution");
	}
    }
    

}

