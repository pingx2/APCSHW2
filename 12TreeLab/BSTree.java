import java.io.*;
import java.util.*;

public class BSTree <T extends Comparable> {

    private class BSTreeNode <T extends Comparable> {
	
	private T root;
	private BSTreeNode<T> left, right;
	
	public BSTreeNode(){
	    root = null;
	}

	public BSTreeNode(T data){
	    root = data;
	    left = null;
	    right = null;
	}
	
	public BSTreeNode(T data, BSTreeNode<T> l, BSTreeNode<T> r){
	    root = data;
	    left = l;
	    right = r;
	}
	
	public T getData(){
	    return root;
	}
	
	public void setData(T value){
	    root = value;
	}

	public BSTreeNode<T> getLeft(){
	    return left;
	}
	
	public void setLeft(BSTreeNode<T> value){
	    left = value;
	}
	
	public BSTreeNode<T> getRight(){
	    return right;
	}
	
	public void setRight(BSTreeNode<T> value){
	    right = value;
	}
 
	public boolean isLeaf(BSTreeNode<T> value){
	    return value.getLeft() == null && value.getRight() == null;
	}

	public String toString(){
	    return "" + getData();
	}

    }

    public BSTreeNode<T> root;

    public BSTree(){
	root = null;
    }

    public boolean isEmpty(){
	return root == null;
    }
    public boolean isLeaf(BSTreeNode<T> t){
	return (t.getLeft() == null && t.getRight() == null);
    }

    /*======== public void add() ==========
      Inputs:   T c  
      Returns: 

      Wrapper for the recursive add method
      ====================*/
    public void add(T c){
	root = add(root, new BSTreeNode<T>(c));
    }

    /*======== public BSTreeNode<T> add() ==========
      Inputs:  BSTreeNode<T> curr
               BSTreeNode<T> t 
      Returns: 

      Add t to the correct place in the tree rooted at curr.
      ====================*/
    private BSTreeNode<T> add(BSTreeNode<T> curr, BSTreeNode<T> t) {
	if(curr == null){
	    return t;
	}else if(t.getData().compareTo(curr.getData()) < 0){
	    curr.setLeft(add(curr.getLeft(),t));
	}else{
	    curr.setRight(add(curr.getRight(),t));
	}
	return curr;
    }
	      

    /*======== public void remove() ==========
      Inputs:   T c  
      Returns: 
      
      Wrapper for the recursive remove method
      ====================*/
    public void remove(T c){
	if(!isEmpty()){
	    root = remove(root, c);
	}
    }

    /*======== public BSTreeNode<T> remove() ==========
      Inputs:   BSTreeNode<T> curr
		T c
      Returns: 

      Should remove the value c from the tree rooted at
      curr, if it exists.
      ====================*/
    private BSTreeNode<T> remove(BSTreeNode<T> curr, T c){
	if(curr.getData() == c){
	    if(isLeaf(curr)){
		return null;
	    }else if(curr.getLeft() == null){
		return curr.getRight();
	    }else if(curr.getRight() == null){
		return curr.getLeft();
	    }else{//both are full
		BSTreeNode<T> temp = curr.getLeft();
		while(temp.getRight() != null){
		    temp = temp.getRight();
		}
		temp.setRight(curr.getRight());
		return curr.getLeft();
	    }
	    //recursive stuff
	}else if(c.compareTo(curr.getData()) < 0){
	    curr.setLeft(remove(curr.getLeft(),c));
	}else{
	    curr.setRight(remove(curr.getRight(),c));
	}
	return curr;
    }


    /*======== public void inOrder()) ==========
      Inputs:   
      Returns: 

      Wrapper for the recursive inOrder method
      ====================*/
    public void inOrder() {
	inOrderHelper( root );
	System.out.println();
    }

    /*======== public void inOrderHelper() ==========
      Inputs:   BSTreeNode<T> t  
      Returns: 
      
      Performs an in-order traversal for the tree with 
      root t.
      ====================*/
    public void inOrderHelper( BSTreeNode<T> t ) {
	if (t == null) 
	    return;
	inOrderHelper( t.getLeft() );
	System.out.print( t.getData() + " ");
	inOrderHelper( t.getRight() );
    }

    /**
     * stolen from: Dennis Yatunin
     */
    
    public int getHeight(){
	return getHeight(root);
    }

    private int getHeight(BSTreeNode<T> r ){
	if(r == null){
	    return 0;
	}else{
	    //System.out.println("recursion height");
	    return 1 + Math.max(getHeight(r.getLeft()),
				getHeight(r.getRight()));
	}
    }

    private int maxLength() {
	// returns the minimum number of characters required
	// to print the data from any node in the tree
	if (root == null)
	    return 0;
	return maxLength(root);
    }

    private int maxLength(BSTreeNode<T> curr) {
	int max = curr.toString().length();
	int temp;
	if (curr.getLeft() != null) {
	    temp = maxLength(curr.getLeft());
	    if (temp > max)
		max = temp;
	}
	if (curr.getRight() != null) {
	    temp = maxLength(curr.getRight());
	    if (temp > max)
		max = temp;
	}
	return max;
    }

    private String spaces(double n) {
	// returns a String of n spaces
	String result = "";
	for (int i = 0; i < n; i++)
	    result += " ";
	return result;
    }

    /*
      getLevel will produce a String for each level of the tree.
      The resulting Strings will look like this:

      ._______________________________
      ._______________._______________
      ._______._______._______._______
      .___.___.___.___.___.___.___.___
      ._._._._._._._._._._._._._._._._

      toString will combine those Strings and provide an output that
      will look like this:

      _______________.
      _______._______________.
      ___._______._______._______.
      _.___.___.___.___.___.___.___.
      ._._._._._._._._._._._._._._._.
      In these diagrams, each dot represents wordLength characters,
      each underscore represents wordLength spaces, and, for any nodes
      that are null, the dots will be "replaced" by underscores.
    */

    private String getLevel(BSTreeNode<T> curr, int currLevel, int targetLevel, int height, int wordLength) {
	if (currLevel == 1){
	    return curr.toString() + spaces(wordLength - curr.toString().length()) +
		spaces(wordLength * Math.pow(2, height - targetLevel + 1) - wordLength);
	}
	String result = "";
	if (curr.getLeft() != null){
	    result += getLevel(curr.getLeft(), currLevel - 1, targetLevel, height, wordLength);
	}else{
	    result += spaces(wordLength * Math.pow(2, height - targetLevel + currLevel - 1));
	}
	if (curr.getRight() != null){
	    result += getLevel(curr.getRight(), currLevel - 1, targetLevel, height, wordLength);
	}else{ 
	    result += spaces(wordLength * Math.pow(2, height - targetLevel + currLevel - 1));
	}
	return result;
    }
		
    public String toString() {
	if (root == null)
	    return "";
	String result = "";
	int height = getHeight();
	int wordLength = maxLength();
	// add the every level of the tree except the last one
	for (int level = 1; level < height; level++){
	    // remove extra spaces from the end of each level's String to prevent lines from
	    // getting unnecessarily long and add spaces to the front of each level's String
	    // to keep everything centered
	    result += spaces(wordLength * Math.pow(2, height - level) - wordLength) +
		getLevel(root, level, level, height, wordLength).replaceFirst("\\s+$", "") +
		"\n";
	}
	// now add the last level (level = height)
	result += getLevel(root, height, height, height, wordLength).replaceFirst("\\s+$", "");
				
	return result;
    }

    public String name(){
	return "zeng.pingping";
    }   

    public static void main(String[] args){

	BSTree tree = new BSTree<Integer>();
	
	tree.remove(10);

	tree.add(5);
	tree.add(3);
	tree.add(1);
	tree.add(7);
	tree.add(6);
	tree.add(8);



	//tree.remove(10);


	System.out.println(tree);

    
    }

}
