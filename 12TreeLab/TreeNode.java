import java.oi.*;
import java.util.*;

public class TreeNode<E>{
    
    private E parent;
    private TreeNode left, right;

    public TreeNode<E>(E data){
	parent = data;
    }



    public E getParent(){
	return parent;
    }

    public void setParent(E value){
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