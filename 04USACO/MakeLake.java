import java.util.*;
import java.io.*;

public class MakeLake{

    int row, column, elevation, num;
    int[][] pasture;
    int[][] instructions;

    public MakeLake(String filename){
	try{
	    Scanner in  = new Scanner(new File(filename));
	    row = in.nextInt();
	    column = in.nextInt();
	    elevation = in.nextInt();
	    num = in.nextInt();
	    pasture = new int[row][column];
	    for(int i = 0; i < row; i++){
		for(int j = 0; j < column; j++){
		    pasture[i][j] = in.nextInt();
		}
	    }
	    instructions = new int[num][3];
	    for(int i = 0; i < num; i++){
		for(int j = 0; j < 3; j++){
		    instructions[i][j] = in.nextInt();
		}
	    }
	}catch(Exception e){
	    System.out.println(filename+" could not be opened.");
	}
    }
    
    public int stomp(){
	int R_s, C_s, D_s;
	for(int i = 0; i < instructions.length; i++){
	    R_s = instructions[i][0];
	    C_s = instructions[i][1];
	    D_s = instructions[i][2];
	    int target = getTarget(D_s, R_s, C_s);
	    for(int r = R_s - 1; r < R_s + 2; r++){
		for(int c = C_s - 1; c < C_s + 2; c++){
		    if(pasture[r][c] > target){
			pasture[r][c] = target;
		    }
		}
	    }
	}
	int total = 0;
	for(int i = 0; i < row; i++){
	    for(int j = 0; j < column; j++){
		if(elevation - pasture[i][j] > 0){
		    pasture[i][j] = elevation - pasture[i][j];
		    total+=pasture[i][j];
		}
	    }
	}
	return total*72*72;
	
    }

    public int getTarget(int D_s, int R_s, int C_s){
	int max = 0;
	for(int r = R_s - 1; r < R_s + 2; r++){
	    for(int c = C_s - 1; c < C_s + 2; c++){
		if(pasture[r][c] > max){
		    max = pasture[r][c];
		}
	    }
	}
	return max - D_s;
    }



    public static void main(String[]args){
	MakeLake a = new MakeLake("makelake.txt");
	System.out.println(a.stomp());


    }

}
