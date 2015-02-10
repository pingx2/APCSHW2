public class Maze{

    public char[][] solvem(char[][] maze){
	int x = 0;
	int y = 0;
	for(int r = 0; r < maze.length; r++){
	    for(int c = 0; c < maze[r].length; c++){
		if(maze[r][c]=='S'){
		    x = c;
		    y = y;
		    break;
		}
	    }
	}
	return solver(maze, x, y);
    }

    public char[][] solver(char[][], int xcor, int ycor){

    }

}		    
