import java.util.*;
import java.io.*;
import java.lang.*;

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
		
	public String toString(){
	    return "["+getx()+" ,"+gety()+"]";
	}
	
    }

    int startx, starty;
    int endx, endy;
    int maxx, maxy;
    char[][] maze;
    int[]moves;
    MyDeque<Coordinate> frontier;

    public Maze(String filename){
	frontier = new MyDeque<Coordinate>(10);
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
	for(int i=0;i<ans.length();i++){
	    char c = ans.charAt(i);
	    maze[i%maxx][i/maxx]= c;
	    if(c=='E'){
		endx = i%maxx;
		endy = i/maxx;
	    }
	}
    }

    public String toString(){
	String ans = "";
	//+maxx+","+maxy+"\n";
	for(int i=0;i<maxx*maxy;i++){
	    if(i%maxx ==0 && i!=0){
		ans+="\n";
	    }
	    ans += maze[i%maxx][i/maxx];
	}
	return ans;
    }
    
    public String toString(boolean animate){
	String ans = toString();
	if(animate){
	    return clear+hide+go(0,0)+ans+"\n"+show;
	}
	return ans;
    }

    public boolean solveBest(boolean animate){
	if(startx < 0){
	    System.out.println("No starting point 'S' found in maze.");
	    return false;
	}
	int count = -1;
	int pr = distance(startx,starty);
	maze[startx][starty] = ' ';
	frontier.add(new Coordinate(startx,starty,count,null),pr);
	while(frontier.size()!=0){
	    if(animate){
		System.out.println(this.toString(animate));
		wait(20);
	    }
	    Coordinate current = frontier.removeSmallest();
	    int x = current.getx();
	    int y = current.gety();
	    count++;
	    pr = distance(x, y-1);
	    if(checkE2(x,y-1,count,current,pr)){
		return true;
	    }else{
		check2(x,y-1,count,current,pr);
	    }	    
	    pr = distancenumMoves(x, y+1);
	    if(checkE2(x,y+1,count,current,pr)){
		return true;
	    }else{
		check2(x,y+1,count,current,pr);
	    }
	    pr = distance(x-1, y);
	    if(checkE2(x-1,y,count,current,pr)){
		return true;
	    }else{
		check2(x-1,y,count,current,pr);
	    }
	    pr = distance(x+1, y);
	    if(checkE2(x+1,y,count,current,pr)){
		return true;
	    }else{
		check2(x+1,y,count,current,pr);
	    }
	}   
	return false;
    }
	   
    public int distance(int x, int y){
return 

    public boolean solveAStar(boolean animate){

    }

    public boolean solveBFS(boolean animate){
	if(startx < 0){ 
	    System.out.println("No starting point 'S' found in maze.");
	    return false;
	}
	int count = -1;
	maze[startx][starty] = ' ';
	frontier.addFirst(new Coordinate(startx,starty,count,null));
	while(frontier.size()!=0){
	    if(animate){
		System.out.println(this.toString(animate));
		wait(20);
	    }
	    Coordinate current = frontier.getFirst();
	    int x = current.getx();
	    int y = current.gety();
	    frontier.removeFirst();
	    count++;
	    if(checkE(x,y-1,count,current)){
		return true;
	    }else{
		check(x,y-1,count,current);
	    }	    
	    if(checkE(x,y+1,count,current)){
		return true;
	    }else{
		check(x,y+1,count,current);
	    }
	    if(checkE(x-1,y,count,current)){
		return true;
	    }else{
		check(x-1,y,count,current);
	    }
	    if(checkE(x+1,y,count,current)){
		return true;
	    }else{
		check(x+1,y,count,current);
	    }
	}   
	return false;
    }
    

    public boolean checkE(int x, int y, int c, Coordinate prev){
	if(maze[x][y] == 'E'){
	    frontier.addLast(new Coordinate(x,y,c,prev)); 
	    return true;
	}
	return false;
    }
    
    public void check(int x, int y, int c, Coordinate prev){
	if(maze[x][y] == ' '){
	    maze[x][y] = 'x';
	    frontier.addLast(new Coordinate(x,y,c,prev));
	}
    }

    public boolean checkE2(int x, int y, int c, Coordinate prev, int pr){
	if(maze[x][y] == 'E'){
	    frontier.add(new Coordinate(x,y,c,prev),pr); 
	    return true;
	}
	return false;
    }
    
    public void check2(int x, int y, int c, Coordinate prev, int pr){
	if(maze[x][y] == ' '){
	    maze[x][y] = 'x';
	    frontier.addLast(new Coordinate(x,y,c,prev),pr);
	}
    }

    public boolean solveDFS(boolean animate){
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
	    System.out.println(this.toString(animate));
	    wait(20);
	}
	if(maze[x][y]=='E'){
	    frontier.addLast(new Coordinate(x,y,n+1,frontier.getLast()));
	    return true;
	}
	if(maze[x][y]==' '){
	    maze[x][y]='x';
	    if(x != startx || y != starty){
		frontier.addLast(new Coordinate(x,y,n+1,frontier.getLast()));
	    }else{
		frontier.addLast(new Coordinate(x,y,n+1,null));
	    }
	    if(solveDFS(x+1,y,n+1,animate)||solveDFS(x-1,y,n+1,animate)||solveDFS(x,y+1,n+1,animate)||solveDFS(x,y-1,n+1,animate)){
		return true;
	    }
	    maze[x][y]='.';
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

    public boolean solveBest(){
	return solveBest(false);
    }
    
    public boolean solveAStar(){
	return solveAStar(false);
    }

    public int[] solutionCoordinates(){ 
	Coordinate current = frontier.getLast();
	int count = 1;
	while(current.hasPrev()){
	    count++;
	    current = current.getPrev();
	}
	moves = new int[count*2];
	//System.out.println(count);
	//System.out.println(frontier.getLast().getnum());
	int i = 1;
	current = frontier.getLast();	
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


    public static void main(String[]args){
	
	Maze m = new Maze("data2.dat");
 
	if(m.solveBFS(true)){
	    System.out.println(m);
	    System.out.println(Arrays.toString(m.solutionCoordinates()));
	}else{
	    System.out.println("No solution");
	}

	
    } 

}
