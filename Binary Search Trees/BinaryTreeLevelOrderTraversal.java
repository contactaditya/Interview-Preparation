import java.util.*;
import java.io.*;

 public class BinaryTreeLevelOrderTraversal {
    Node root;	    
    Node previous;
	
    public List<List<Integer>> printLevelOrderTraversal(Node root) {
       List<List<Integer>> result = new ArrayList<List<Integer>>();
       levelHelper(result, root, 0);
       return result;
    }
    
    public void levelHelper(List<List<Integer>> result, Node root, int height) {
       if (root == null) {
          return;
       }
       if (height >= result.size()) {
         result.add(new LinkedList<Integer>());
       }
       result.get(height).add(root.data);
       levelHelper(result, root.left, height+1);
       levelHelper(result, root.right, height+1);
    }
	    
    public List<List<Integer>> printLevelOrderTraversal1(Node root) {
       Queue<Node> queue = new LinkedList<Node>();
       List<List<Integer>> levelOrderTraversal = new LinkedList<List<Integer>>();
        
       if(root == null) {
         return levelOrderTraversal;
       }
        
       queue.offer(root);
       while(!queue.isEmpty()){
         int levelNumber = queue.size();
         List<Integer> currentLevel = new LinkedList<Integer>();
         for(int i=0; i<levelNumber; i++) {
           if(queue.peek().left != null) {
             queue.offer(queue.peek().left);
           }
           if(queue.peek().right != null) {
             queue.offer(queue.peek().right);
           }
           currentLevel.add(queue.poll().data);
         }
         levelOrderTraversal.add(currentLevel);
       }
       return levelOrderTraversal;
    }

    public static void main(String[] args) {
       BinaryTreeLevelOrderTraversal tree = new BinaryTreeLevelOrderTraversal();
       tree.root = new Node(3);
       tree.root.left = new Node(5);
       tree.root.right = new Node(2);
       tree.root.left.left = new Node(1);
       tree.root.left.right = new Node(4);
       tree.root.right.left = new Node(6);
       List<List<Integer>> result = new LinkedList<List<Integer>>();
       result = tree.printLevelOrderTraversal(tree.root);		
		     
       System.out.print("Level order traversal of binary tree is: " + result);
	  
    }
 }
