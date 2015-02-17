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
	return hide + cleaer + go(0,0) + ans + "\n" + show;
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

    }
