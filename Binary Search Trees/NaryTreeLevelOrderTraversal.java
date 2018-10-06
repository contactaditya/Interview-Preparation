import java.util.*;
import java.io.*;

  public class NaryTreeLevelOrderTraversal {
	  
    public static List<List<Integer>> levelOrder(NaryTreeNode root) {
      return levelOrder(root, 0, new ArrayList<>()); 
    }  
	
    private static List<List<Integer>> levelOrder(NaryTreeNode root, int level, List<List<Integer>> order) {
      if (root == null) { 
        return order;
      }
      List<Integer> list = order.size() > level ?  order.get(level) : new ArrayList<Integer>();
      list.add(root.data);
      if (order.size() <= level) {
        order.add(list);
      }
      if(root.children != null) {
        for (NaryTreeNode node : root.children) {
          levelOrder(node, level + 1, order);
        }
      }
      return order;
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
	  
      List<List<Integer>> result = new ArrayList<List<Integer>>(); 
      result = levelOrder(node1);		
	  
      System.out.println("Level order traversal of the N-ary tree is: ");	
      System.out.println('[');
      for(List<Integer> innerList : result) {
	System.out.println(innerList + " ");
      }
      System.out.println(']');
    }
  }
