import java.io.*;
import java.util.*;

public class BTree<E> {

    public static final int PRE_ORDER = 0;
    public static final int IN_ORDER = 1;
    public static final int POST_ORDER = 2;
    
    private class TreeNode<T>{
	
	private T parent;
	private TreeNode left, right;
	
	public TreeNode(T data){
	    parent = data;
	    left = null;
	    right = null;
	}
	
	public TreeNode(T data, TreeNode l, TreeNode r){
	    parent = data;
	    left = l;
	    right = r;
	}
	
	public T get(){
	    return parent;
	}
	
	public void set(T value){
	    parent = value;
	}

	public TreeNode getLeft(){
	    return left;
	}
	
	public void setLeft(TreeNode value){
	    left = value;
	}
	
	public TreeNode getRight(){
	    return right;
	}
	
	public void setRight(TreeNode value){
	    right = value;
	}
    }

    private TreeNode<E> root;

    public BTree() {
	root = null;
    }

    /*======== public void add() ==========
      Inputs:   E d
      Returns: 
      
      Wrapper method for the recursive add()
      ====================*/     
    public void add(E d) { 
	add(root, new TreeNode<E> d);
    }
    
    /*======== public void add() ==========
      Inputs:   TreeNode<E> curr, TreeNode<E> bn  
      Returns: 
      
      Adds bn to the tree rooted at curr. If curr has 
      an available child space, then attach bn there.

      Otherwise, try to add at the subtree rooted at
      one of curr's children. Choose the child to be
      added to randomly.
      ====================*/
    private TreeNode<T> add(TreeNode<E> curr, TreeNode<E> bn){
	//Random r = new Random();
	//int n = 
	if(curr == null){
	    curr = bn;
	}
	else if(curr.getLeft()==null && curr.getRight==null){
	    if(n == 0){
		curr.setLeft(bn);
	    }else{
		curr.setRight(bn);
	    }
	}else if(curr.getLeft() == null){
	    curr.setLeft(bn);
	}else if(curr.getRight() == null){
	    curr.setRight(bn);
	}else{
	    TreeNode<E> temp = curr.get();
	    if(n == 0){
		curr.setLeft(bn);
		add(curr,temp);
	    }else{
		curr.setRight(bn);
		add(curr,temp);
	    }
	}
    }
    
    public void traverse( int mode) {
	if (mode == PRE_ORDER)
	    preOrder(root);
	else if (mode == IN_ORDER )
	    inOrder( root );
	else
	    postOrder( root );
	System.out.println();
    }

    /*======== public void preOrder() ==========
      Inputs:   TreeNode<E> curr  
      Returns: 
      
      Prints out the elements in the tree by doing an
      pre-order Traversal
      ====================*/
    public void preOrder(TreeNode<E> curr){
	String s = "";
	
    }


    /*======== public void inOrder() ==========
      Inputs:   TreeNode<E> curr  
      Returns: 
      
      Prints out the elements in the tree by doing an
      in-order Traversal
      ====================*/
    public void inOrder(TreeNode<E> curr) {
    }

    /*======== public void postOrder() ==========
      Inputs:   TreeNode<E> curr  
      Returns: 
      
      Prints out the elements in the tree by doing a
      post-order Traversal    

      ====================*/
    public void postOrder(TreeNode<E> curr) {
    }
    
    /*======== public int getHeight()) ==========
      Inputs:   
      Returns: The height of the tree

      Wrapper for the recursive getHeight method
      ====================*/
    public int getHeight() {
	return getHeight(root);
    }
    /*======== public int getHeight() ==========
      Inputs:   TreeNode<E> curr  
      Returns:  The height of the tree rooted at node curr
      
      ====================*/
    public int getHeight(TreeNode<E> curr) {
	return -1;
    }

    /*======== public String getLevel() ==========
      Inputs:   TreeNode<E> curr
                int level
                int currLevel  
      Returns: A string containing all the elements on the
               given level, ordered left -> right
      
      ====================*/
    public String getLevel(TreeNode<E> curr, int level, int currLevel) {
	return "";
    }
    
    /*======== public String toString()) ==========
      Inputs:   
      Returns: A string representation of the tree
     
      This string should display each level as a separate line.
      A simple version might look something like this:

      0
      1 2
      3 4 5

      Note that you cannot tell exactly where 3, 4 and 5 lie.
      That is ok, but if you want a CHALLENGE, you can try to
      get the output to look nicer, something like this:
             0

          1      2

            3  4   5

      ====================*/
    public String toString() {
	return "";
    }
	

    public static void main(String[] args) {

	BTree<Integer> t = new BTree<Integer>();

	for ( int i=0; i < 8; i++ ) 
	    t.add( i );
	System.out.println( "Pre-order: ");
	t.traverse( PRE_ORDER );
	System.out.println( "In-order: ");
	t.traverse( IN_ORDER );
	System.out.println( "Post-order: ");
	t.traverse( POST_ORDER );
	System.out.println( "Height: " + t.getHeight() );

	System.out.println( t );
    }
}