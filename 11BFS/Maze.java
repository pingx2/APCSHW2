import java.util.*;

public class Maze{

    public String name(){
	return "zeng.pingping";
    }
    
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



} 