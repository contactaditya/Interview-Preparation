import java.util.*;
import java.io.*;

  public class LeafSimilarTrees {
    private Node root1;	
    private Node root2;	
	
    public static boolean leafSimilar(Node root1, Node root2) {
      List<Integer> leaves1 = new ArrayList<Integer>();
      List<Integer> leaves2 = new ArrayList<Integer>();
      dfs(root1, leaves1);
      dfs(root2, leaves2);
      return leaves1.equals(leaves2);  
    }

    private static void dfs(Node node, List<Integer> leafValues) {  
      if (node == null) {
	return;
      }
      if (node.left == null && node.right == null) {
        leafValues.add(node.data);
      }
      dfs(node.left, leafValues);
      dfs(node.right, leafValues);
    }

    public static void main(String[] args) {    
      LeafSimilarTrees tree = new LeafSimilarTrees();
      tree.root1 = new Node(1);
      tree.root1.left = new Node(2);
      tree.root1.right = new Node(3);
      tree.root1.left.left = new Node(4);
      tree.root1.left.right = new Node(5);
		   
      tree.root2 = new Node(1);
      tree.root2.left = new Node(2);
      tree.root2.right = new Node(3); 
      tree.root2.left.left = new Node(4);
      tree.root2.left.right = new Node(5);
		 
      if (leafSimilar(tree.root1, tree.root2) == true) {
	System.out.println("The two binary trees are leaf similar.");
      }
      else {
  	System.out.println("The two binary trees are not leaf similar.");
      }
    }
  }
