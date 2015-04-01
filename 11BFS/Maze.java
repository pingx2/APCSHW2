import java.util.*;

public class Maze{

    private static final String clear =  "\033[2J";
    private static final String hide =  "\033[?25l";
    private static final String show =  "\033[?25h";
    
    private String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }

    private class Coordinate{

	private int xcor, ycor;
	private Coordinate prev;

	public Coordinate(int x, int y, Coordinate c){
	    xcor = x;
	    ycor = y;
	    prev = c;
	}

	public int getx(){
	    return xcor;
	}

	public int gety(){
	    return ycor;
	}
	public Coordinate getc(){
	    return prev;
	}

    }

    int startx, starty;
    int maxx, maxy;
    char[][] maze;
    MyDeque<Coordinate> frontier;

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
	String ans = ""+maxx+","+maxy+"\n";
	for(int i=0;i<maxx*maxy;i++){
	    if(i%maxx ==0 && i!=0){
		ans+="\n";
	    }
	    ans += maze[i%maxx][i/maxx];
	}
	return ans;
    }

    public String toString(boolean animate){
	if(!animate){
	    toString();
	}
	String ans = ""+maxx+","+maxy+"\n";
	for(int i=0;i<maxx*maxy;i++){
	    if(i%maxx ==0 && i!=0){
		ans+="\n";
	    }
	    ans += maze[i%maxx][i/maxx];
	}
	return hide+go(0,0)+ans+"\n"+show;
    }

    private boolean solve(boolean animate, int mode){
	
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

    public int[] solutionCoordinates(){ 

    }    

    public String name(){
	return "zeng.pingping";
    }



} 