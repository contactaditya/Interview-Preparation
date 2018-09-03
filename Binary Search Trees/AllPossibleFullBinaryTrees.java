import java.util.*;
import java.io.*;

  public class AllPossibleFullBinaryTrees {
	static Map<Integer,List<Node>> memo = new HashMap<>();
	  
	public static List<Node> allPossibleFBT(int N) {
	  if (!memo.containsKey(N)) {	   
		List<Node> answer = new LinkedList<Node>();   
		if (N == 1) {
          answer.add(new Node(0));
        } else if (N % 2 == 1) {
          for (int x = 0; x < N; x++) {
            int y = N - 1 - x;	 
            for (Node left: allPossibleFBT(x)) {
              for (Node right: allPossibleFBT(y)) {
                Node node = new Node(0);
                node.left = left;
                node.right = right;
                answer.add(node);  
              }
            }	 
          }
        }
	    memo.put(N, answer); 
	  }
	
	  return memo.get(N);     
	}

	public static void printInorderTraversal(Node node) {	 
	  if (node == null) {
		return;
	  }
		 
      printInorderTraversal(node.left);
	  System.out.print(node.data + " ");	
	  printInorderTraversal(node.right);
    }     
	  
	public static void main(String[] args) {  
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the number of nodes in the full binary tree: ");
      int N = input.nextInt();
      
      
      
      List<Node> result = new ArrayList<Node>();
      result = allPossibleFBT(N);
      System.out.println();
	  System.out.println("A list of all possible full binary trees with " + N + " nodes is: ");
	  for(int i = 0; i < result.size(); i++) {
		printInorderTraversal(result.get(i));	
		System.out.println("");
	  }
	}
  }
