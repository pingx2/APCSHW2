import java.util.*;
import java.io.*;

public class CowTravelling{

    int row, column, time;
    int r1, c1, r2, c2;
    char[][] pasture;

    public CowTravelling(String filename){
	try{
	    Scanner in = new Scanner(new File(filename));
	    row = in.nextInt();
	    column = in.nextInt();
	    time = in.nextInt();
	    pasture = new char[row][column];
	    for(int i = 0; i < row; i++){
		String line = in.next();
		for(int j = 0; j < column; j++){
		    pasture[i][j] = line.charAt(j);
		}
	    }
	    r1 = in.nextInt()-1;
	    c1 = in.nextInt()-1;
	    r2 = in.nextInt()-1;
	    c2 = in.nextInt()-1;
	}catch(Exception e){
	    System.out.println(filename+" could not be opened.");
	}
    }

    public int travel(){
	return travel(c1,r1,0);
    }

    public int travel(int x, int y, int ctime){
	if(x < 0 || x >= column || y < 0 || y >= row){
	    return 0;
	}
	if(time == ctime && ( x != c2 || y != r2)){
	    return 0;
	}
	if(time == ctime && x == c2 && y == r2){
	    return 1;
	}
	if(pasture[y][x] == '*'){
	    return 0;
	}
	return travel(x+1,y,ctime+1) + travel(x-1,y,ctime+1) + 
	    travel(x,y+1,ctime+1) + travel(x,y-1,ctime+1);
    }


    public String name(){
	return "zeng.pingping";
    }
    
    public static void main(String[]args){

	CowTravelling a = new CowTravelling("cowtravelling.txt");
	System.out.println(a.travel());


    }

}
