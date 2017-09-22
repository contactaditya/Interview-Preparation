import java.util.*;
import java.io.*;

 public class BinaryTreeLevelOrderTraversal {
     Node root;	    
     Node previous;
	    
     public List<List<Integer>> printLevelOrderTraversal(Node root) {
	Queue<Node> queue = new LinkedList<Node>();
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
        
        if(root == null) {
          return wrapList;
        }
        
        queue.offer(root);
        while(!queue.isEmpty()){
          int levelNumber = queue.size();
          List<Integer> subList = new LinkedList<Integer>();
          for(int i=0; i<levelNumber; i++) {
            if(queue.peek().left != null) {
              queue.offer(queue.peek().left);
            }
            if(queue.peek().right != null) {
              queue.offer(queue.peek().right);
            }
            subList.add(queue.poll().data);
          }
          wrapList.add(subList);
        }
       return wrapList;
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
