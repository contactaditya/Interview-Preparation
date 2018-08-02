import java.util.*;
import java.io.*;

  public class AllNodesDistanceKInBinaryTree {
    Node root; 
    Node target;
    List<Integer> result;
    int K;
	  
    public List<Integer> distanceK(Node root, Node target, int K) { 
      result = new LinkedList<Integer>();
      this.target = target;
      this.K = K;
      dfs(root);
      
      return result;      
    }	  

    private int dfs(Node node) {   
      if (node == null) {
        return -1;
      }
      else if (node == target) {
        subtree_add(node, 0); // We should add nodes that are distance K in the subtree rooted at target.
        return 1;
      }
      else {
        int L = dfs(node.left), R = dfs(node.right);  
        if (L != -1) {
          if (L == K) {
            result.add(node.data);
          }
          subtree_add(node.right, L + 1); 
          return L + 1;
        } else if (R != -1) {
          if (R == K) {
            result.add(node.data);
          }
          subtree_add(node.left, R + 1);
          return R + 1;
        } else {
          return -1;
        } 
      }
    }
	
    // Add all nodes 'K - dist' from the node to answer.
    public void subtree_add(Node node, int distance) {
      if (node == null) {
    	return;
      }
      if (distance == K) {
        result.add(node.data);
      }
      else {
        subtree_add(node.left, distance + 1);
        subtree_add(node.right, distance + 1);
      }
    }

    public static void main(String[] args) {     
      AllNodesDistanceKInBinaryTree tree = new AllNodesDistanceKInBinaryTree();
      tree.root = new Node(3);
      tree.root.left = new Node(5);
      tree.root.right = new Node(1);
      tree.root.left.left = new Node(6);
      tree.root.left.right = new Node(2);
      tree.root.right.left = new Node(0);
      tree.root.right.right = new Node(8);
      tree.root.left.right.left = new Node(7);
      tree.root.left.right.right = new Node(4);
      
      tree.target = tree.root.left;
    
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the value of distance K from the target node: ");
      int K = input.nextInt();  
      
      List<Integer> result = new ArrayList<Integer>();
      result = tree.distanceK(tree.root, tree.target, K);
      System.out.println();
      System.out.println("The values of all nodes that have a distance K from the target node in a Binary Tree is: " + result);
    }
  }
