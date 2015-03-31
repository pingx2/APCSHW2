import java.util.*;

public class Maze{

    private static final String clear =  "\033[2J";
    private static final String hide =  "\033[?25l";
    private static final String show =  "\033[?25h";

    public String name(){
	return "zeng.pingping";
    }
    

    //frontier class


    private class Coordinate{

	private int xcor, ycor;
	private Coordinate cor;

	public Coordinate(int x, int y, Coordinate c){
	    xcor = x;
	    ycor = y;
	    cor = c;
	}

    }

    private int[][] num;
    private Coordinate[] moves;

    private static final DFS = 1;


    public Maze(String filename){
	startx = -1;
	starty = -1;
	String ans = "";
	try{
	    Scanner in = new Scanner(new File(filename));
	    while(in.hasNext()){
		String line= in.nextLine();
		if(maxy==0){
		    maxx=line.length();
		}
		maxy++;
		ans+=line;
	    }
	}
	catch(Exception e){
	    System.out.println("File: "+filename+" could not be opened.");
	    e.printStackTrace();
	    System.exit(0);
	}
	maze = new char[maxx][maxy];
	for(int i=0;i<ans.length();i++){
	    char c = ans.charAt(i);
	    maze[i%maxx][i/maxx]= c;
	    if(c=='S'){
		startx = i%maxx;
		starty = i/maxx;
	    }
	}
    }

    public String toString(){

    }

    public boolean solveBFS(boolean animate){
	
    }

    public boolean solveDFS(boolean animate){
	
    }

    public boolean solveBFS(){
	return solveBFS(false);
    }

    public boolean solveDFS(){
	return solveDFS(false);
    }
	




} 