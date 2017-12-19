import java.util.*;
import java.io.*;

  public class ClosestLeafInABinaryTree { 	
	Node root;	    
	Node previous;
	  
	public static int findClosestLeaf(Node root, int k) {
	  Map<Node, Node> backMap = new HashMap<>(); // store all edges that trace node back to its parent
	  Queue<Node> queue = new LinkedList<>();    // the queue used in BFS
	  Set<Node> visited = new HashSet<>();       // store all visited nodes
	        
	  // DFS: search for node whoes data == k
	  Node kNode = DFS(root, k, backMap);
	  queue.add(kNode);
	  visited.add(kNode);
	        
	  // BFS: find the shortest path
	  while(!queue.isEmpty()) {
	    Node current = queue.poll();
	    if(current.left == null && current.right == null) {
	       return current.data;
	    }
	    if(current.left != null && visited.add(current.left)) {
	       queue.add(current.left);
	    }
	    if(current.right != null && visited.add(current.right)) {
	       queue.add(current.right);
	    }
	    if(backMap.containsKey(current) && visited.add(backMap.get(current))) {  // go alone the back edge
	       queue.add(backMap.get(current));
	    }
	  }
	  return -1; // never hit
	}	  

	private static Node DFS(Node root, int k, Map<Node, Node> backMap) {
      if(root.data == k) {
	    return root;
	  }
	  if(root.left != null) {
	    backMap.put(root.left, root); // add back edge
	    Node left = DFS(root.left, k, backMap);
	    if(left != null) {
	      return left;
	    }
	  }
	  if(root.right != null) {
	    backMap.put(root.right, root); // add back edge
	    Node right = DFS(root.right, k, backMap);
	    if(right != null) {
	      return right;
	    }
	  }
	  return null;
	}

	public static void main(String[] args) {  
	  ClosestLeafInABinaryTree tree = new ClosestLeafInABinaryTree();
	  tree.root = new Node(1);
	  tree.root.left = new Node(2);
	  tree.root.right = new Node(3);
	  tree.root.left.left = new Node(4);
	  tree.root.left.left.left = new Node(5);
	  tree.root.left.left.left.left = new Node(6);
      Scanner input = new Scanner(System.in);
	  System.out.print("Enter the target key: ");
	  int k = input.nextInt();  
	  int closestLeafNode = findClosestLeaf(tree.root, k); 
	  System.out.println();
	  System.out.println("The value of the closest leaf node to target " + k + " in the binary tree is: " + closestLeafNode);
	  
	}
  }
