import java.util.*;
import java.io.*;

public class Maze{

    private static final String clear =  "\033[2J";
    private static final String hide =  "\033[?25l";
    private static final String show =  "\033[?25h"; 
    private String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }

    private class Coordinate{

	private int xcor, ycor, num;
	private Coordinate prev;

	public Coordinate(int x, int y, int n, Coordinate c){
	    xcor = x;
	    ycor = y;
	    num = n;
	    prev = c;
	}

	public int getx(){
	    return xcor;
	}

	public int gety(){
	    return ycor;
	}
	public int getnum(){
	    return num;
	}

	public Coordinate getPrev(){
	    return prev;
	}

	public boolean hasPrev(){
	    return (prev != null);
	}
		

    }

    int startx, starty;
    int maxx, maxy;
    char[][] maze;
    MyDeque<Coordinate> frontier;

    public Maze(String filename){
	frontier = new MyDeque<Coordinate>();
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
	    return toString();
	}
	String ans = toString();
	return clear+hide+go(0,0)+ans+"\n"+show;
    }

    //private boolean solve(boolean animate, int mode){}

    public boolean solveBFS(boolean animate){
	//return solve(animate, -1);
	if(startx < 0){ 
	    System.out.println("No starting point 'S' found in maze.");
	    return false;
	}
	int count = 0;
	maze[starty][startx] = ' ';
	frontier.addLast(new Coordinate(startx,starty,count,null));
	while(frontier.size()!=0){
	    Coordinate current = frontier.removeFirst();
	    int xcor = current.getx();
	    int ycor = current.gety();
	    count++;
	    if(checkE(x,y-1,count,current)){
		return true;
	    }else{
		check(x,y-1,count,current);
	    }
	    
	}   
    }


    public boolean checkE(int x, int y, int c, Coordinate prev){
	if(maze[y][x] == 'E'){
	    maze[y][x] = 'x';
	    frontier.addLast(new Coordinate(x,y,c,prev)); 
	    return true;
	}
	return false;
    }
    
    public void check(int x, int y, int c, Coordinate prev){
	if(maze[y][x] == ' '){
	    maze[y][x] == 'x';
	    frontier.addLast(newCoordinate(x,y,c,prev));
	}
    }
    
		
    /*
    public boolean solveBFS(int x, int y, int n, boolean animate){
	if(animate){
	    System.out.println(this);
	    wait(20);
	}
	if(maze[y][x]=='E'){
	    frontier.addLast(new Coordinate(x,y,n+1,frontier.getLast()));
	    return true;
	}
	if(maze[y][x]==' '){
	    frontier.addLast(new Coordinate(x,y,n+1,frontier.getLast()));
	    maze[y][x]='x';
    }
    */

    public boolean solveDFS(boolean animate){
	//return solve(animate, 0);
	if(startx < 0){
	    System.out.println("No starting point 'S' found in maze.");
	    return false;
	}else{
	    maze[startx][starty]=' ';
	    return solveDFS(startx,starty,0,animate);
	}
    }
    
    public boolean solveDFS(int x, int y, int n, boolean animate){
	if(animate){
	    System.out.println(this);
	    wait(20);
	}
	if(maze[y][x]=='E'){
	    frontier.addLast(new Coordinate(x,y,n+1,frontier.getLast()));
	    return true;
	}
	if(maze[y][x]==' '){
	    maze[y][x]='x';
	    if(x != startx && y != starty){
		Coordinate current = new Coordinate(x,y,n+1,frontier.getLast());
	    }else{
		Coordinate current = null;
		frontier.addLast(new Coordinate(x,y,n+1,current));
	    }
	    if(solveDFS(x+1,y,n+1,animate)||solveDFS(x-1,y,n+1,animate)||solveDFS(x,y+1,n+1,animate)||solveDFS(x,y-1,n+1,animate)){
		return true;
	    }
	    maze[y][x]='.';
	    frontier.removeLast();
	}     
	return false;
    }

    public boolean solveBFS(){
	return solveBFS(false);
    }

    public boolean solveDFS(){
	return solveDFS(false);
    }

    public int[] solutionCoordinates(){ 
	int[] moves = new int[frontier.getLast().getnum()+1];
	int i = 1;
	Coordinate current = frontier.getLast();
	while(current.hasPrev()){
	    moves[moves.length - i] = current.getx();
	    i++;
	    moves[moves.length - i] = current.gety();
	    i++;
	    current = current.getPrev();
	}
	moves[1] = current.getx();
	moves[0] = current.gety();
	return moves;
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



} 
