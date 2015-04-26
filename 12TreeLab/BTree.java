import java.io.*;
import java.util.*;

public class BTree<E> {

    public static final int PRE_ORDER = 0;
    public static final int IN_ORDER = 1;
    public static final int POST_ORDER = 2;
    
    private class TreeNode<T>{
	
	private T parent;
	private TreeNode<T> left, right;
	
	public TreeNode(T data){
	    parent = data;
	    left = null;
	    right = null;
	}
	
	public TreeNode(T data, TreeNode<T> l, TreeNode<T> r){
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

	public TreeNode<T> getLeft(){
	    return left;
	}
	
	public void setLeft(TreeNode<T> value){
	    left = value;
	}
	
	public TreeNode<T> getRight(){
	    return right;
	}
	
	public void setRight(TreeNode<T> value){
	    right = value;
	}
    }

    private TreeNode<E> root;
    private Random r;

    public BTree() {
	root = null;
	r = new Random();
    }

    /*======== public void add() ==========
      Inputs:   E d
      Returns: 
      
      Wrapper method for the recursive add()
      ====================*/     
    public void add(E d){
	if(root == null){
	    root = new TreeNode<E>(d);
	}else{ 
	    add(root, new TreeNode<E>(d));
	}
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
    private void add(TreeNode<E> curr, TreeNode<E> bn){
	int n = r.nextInt(2);
	if(curr.getLeft()==null && curr.getRight()==null){
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
	    if(n == 0){
		add(curr.getLeft(),bn);
	    }else{
		add(curr.getRight(),bn);
	    }
	}
    }
    
    public void traverse(int mode) {
	if (mode == PRE_ORDER)
	    preOrder(root);
	else if (mode == IN_ORDER)
	    inOrder(root);
	else
	    postOrder(root);
	System.out.println();
    }

    /*======== public void preOrder() ==========
      Inputs:   TreeNode<E> curr  
      Returns: 
      
      Prints out the elements in the tree by doing an
      pre-order Traversal
      ====================*/
    public void preOrder(TreeNode<E> curr){
	//VTT
	if(curr != null){
	    if(curr.getLeft() == null && curr.getRight() == null){
		System.out.println(curr.get());
	    }else{
		System.out.println(curr.get());
		preOrder(curr.getLeft());
		preOrder(curr.getRight());
	    }
	}
    }


    /*======== public void inOrder() ==========
      Inputs:   TreeNode<E> curr  
      Returns: 
      
      Prints out the elements in the tree by doing an
      in-order Traversal
      ====================*/
    public void inOrder(TreeNode<E> curr){
	//TVT
	if(curr != null){
	    if(curr.getLeft() == null && curr.getRight() == null){
		System.out.println(curr.get());
	    }else{
		inOrder(curr.getLeft());
		System.out.println(curr.get());
		inOrder(curr.getRight());
	    }
	}
    }


    /*======== public void postOrder() ==========
      Inputs:   TreeNode<E> curr  
      Returns: 
      
      Prints out the elements in the tree by doing a
      post-order Traversal    

      ====================*/
    public void postOrder(TreeNode<E> curr){
	//TTV
	if(curr != null){
	    if(curr.getLeft() == null && curr.getRight() == null){
		System.out.println(curr.get());
	    }else{
		postOrder(curr.getLeft());
		postOrder(curr.getRight());
		System.out.println(curr.get());
	    }
	}
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
	if(curr == null){
	    return 0;
	}
	if(curr.getLeft() == null && curr.getRight() == null){
	    return 1;
	}
	if(curr.getLeft() == null){
	    return 1 + getHeight(curr.getRight());
	}
	if(curr.getRight() == null){
	    return 1 + getHeight(curr.getLeft());
	}
	return 1 + Math.max(getHeight(curr.getLeft()),getHeight(curr.getRight()));
    }

    /*======== public String getLevel() ==========
      Inputs:   TreeNode<E> curr
                int level
                int currLevel  
      Returns: A string containing all the elements on the
               given level, ordered left -> right
      
      ====================*/
    public String getLevel(TreeNode<E> curr, int level, int currLevel) {
	if(curr == null){
	    return "";
	}
	if(level == currLevel){
	    return curr.get() + " ";
	}
	return getLevel(curr.getLeft(),level,currLevel+1) + getLevel(curr.getRight(),level,currLevel+1);
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
	String result = "";
	for(int i = 0; i < getHeight(root); i++){
	    result += getLevel(root,i,0) + "\n";
	}
	return result;
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
