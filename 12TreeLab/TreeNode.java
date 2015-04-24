import java.io.*;
import java.util.*;

public class TreeNode<T>{
    
    private T parent;
    private TreeNode left, right;

    public TreeNode(T data){
	parent = data;
    }

    public TreeNode(T data, TreeNode l, TreeNode r){
	parent = data;
	left = l;
	right = r;
    }

    public T getParent(){
	return parent;
    }

    public void setParent(T value){
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