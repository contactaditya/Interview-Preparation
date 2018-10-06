import java.util.*;
import java.io.*;

  class NaryTreeNode {
    int data;
    List<NaryTreeNode> children;
    
    public NaryTreeNode() {}

    public NaryTreeNode(int data, List<NaryTreeNode> children) {
      this.data = data;
      children = new ArrayList<NaryTreeNode>();
    }
    
    public NaryTreeNode(int data) {
      this.data = data;
    }

    public void addChild(NaryTreeNode child) {
      children.add(child);
    }
  };

  public class NaryTreePostorderTraversal {
	
    public static List<Integer> postorder(NaryTreeNode root) {  
      List<Integer> list = new ArrayList<Integer>();        
      helper(root, list);		     		  	
      return list;            
    }
	  
    public static void helper(NaryTreeNode root, List<Integer> list) {  
      if (root == null) {
	return;
      }
	   
      if(root.children != null) {
	for(NaryTreeNode node : root.children) {
          helper(node, list);
	}
      }
	  
      list.add(root.data);		  
    }  
	
    public static List<Integer> postorder1(NaryTreeNode root) {  
      List<Integer> result = new ArrayList<Integer>();	
      if (root == null) {
	return result;
      }
	  
      java.util.Stack<NaryTreeNode> stack = new java.util.Stack<NaryTreeNode>();
      stack.add(root);
      
      while(!stack.isEmpty()) {
        root = stack.pop();
        result.add(root.data);
        if(root.children != null) {
          for(NaryTreeNode node : root.children) {
            stack.add(node);
          }
        }
      }
		     
      Collections.reverse(result);		
      return result;      
    }  

    public static void main(String[] args) { 	 
      NaryTreeNode node5 = new NaryTreeNode(5);
      NaryTreeNode node6 = new NaryTreeNode(6);
      NaryTreeNode node3 = new NaryTreeNode(3);
	  
      node3.children = new ArrayList<NaryTreeNode>();
      node3.children.add(node5);
      node3.children.add(node6);
      
      NaryTreeNode node2 = new NaryTreeNode(2);
      NaryTreeNode node4 = new NaryTreeNode(4);
      NaryTreeNode node1 = new NaryTreeNode(1);
	  
      node1.children = new ArrayList<NaryTreeNode>();
      node1.children.add(node3);
      node1.children.add(node2);
      node1.children.add(node4);
	  
      List<Integer> result = postorder1(node1);		
      System.out.print("Postorder traversal of the N-ary tree is: " + result);	
    }
  }
