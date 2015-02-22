import java.util.*;
import java.io.*;


public class NQueens{

    //constants for the class
    //terminal specific character to clear screen , or hide/show cursor
    final static String clear =  "\033[2J";
    final static String hide =  "\033[?25l";
    final static String show =  "\033[?25h";
    
    private char[][]board;
    
    //terminal specific character to move the cursor
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
	for(int i = 0; i < board.length; i++){
	    for(int j = 0; j < board[i].length; j++){
		board[i][j] = '-';
	    }
	}
    }

    public boolean solve(){
	return solve(0);
    }

    public boolean solve(int x){
	return solve(x,1);
    }

    public boolean check(int x, int y){
	for(int i = 0; i < board.length; i++){
	    for(int j = 0; j < board.length; j++){
		if(board[i][j]=='Q'){
		    if(i == y){
			return false;
		    }
		    if(j == x){
			return false;
		    }
		    if(Math.abs(i-y) == Math.abs(j-x)){
			return false;
		    }
		}
	    }
	}
	return true;
    }
	/*
       	for(int r = 0; r < board.length; r++){
	    if(r!=y && board[r][x] == 'Q'){
		return false;
	    }
	}
	for(int c = 0; c < board.length; c++){
	    if(c!=x && board[y][c] == 'Q'){
		return false;
	    }
	}
        //checkdiagonal
	}
	*/
    	


    public boolean solve(int y, int count){
	//System.out.println(this);
	//wait(10);
	if(y < 0 || y >= board.length){
	    return true;
	}
	if(count == board.length+1){
	    return true;
	}
	for(int x = 0; x < board.length; x++){
	    if(check(x,y) && y < board.length){
		board[y][x] = 'Q';
		if(solve(y+1, count+1)){
		    return true;
		}
		board[y][x] = '-';
	    }
	}
	return(solve(y+1, count));
    }
    /*
      if(check(x,y) && board[x][y] == '_'){
	    board[x][y] = 'Q';
	    if(solve(x+1,y+2,count+1) || 
	       solve(x-1,y+2,count+1) || 
	       solve(x+1,y-2,count+1) ||
	       solve(x-1,y-2,count+1) ||
	       solve(x+2,y+1,count+1) ||
	       solve(x-2,y+1,count+1) ||
	       solve(x+2,y-1,count+1) ||
	       solve(x-2,y-1,count+1)){
		return true;
	    }
	    board[x][y]='_';
	}
	return false;		
    }
	*/

    public static void main(String[]args){
	NQueens a = new NQueens(Integer.parseInt(args[0]));

	if(a.solve()){
	    System.out.println(a);
	}else{
	    System.out.println("No Solution");
	}
    }
	

}
