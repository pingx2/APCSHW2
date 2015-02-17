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
		board[i][j] = '_';
	    }
	}
    }

    public boolean solve(){
	return solve(0);
    }

    public boolean solve(int x){
	return solve(x,0,1);
    }

    public boolean check(int x, int y){
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


    public boolean solve(int x, int y, int count){
	//System.out.println(this);
	//wait(10);
	if(x < 0 || x >= board.length || y < 0 || y >= board.length){
	    return false;
	}
	if(count > board.length){
	    return true;
	}
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
}
