import java.util.*;
import java.io.*;

  public class MaximumDepthOfNaryTree {
    public static int max = 0;
	  
    public static int maxDepth(NaryTreeNode root) {  
      if (root == null) {
        return 0; 
      }
      int max = 0;
      if(root.children != null) {
        for (NaryTreeNode child : root.children) { // replace left & right to for loop
          int value = maxDepth(child);
          
          if (value > max) {
            max = value;
          }
        }
      }
	  
      return max + 1;      
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
		  
      int maxDepth = maxDepth(node1);		
      System.out.print("The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node is: " + maxDepth);	
    }
  }
