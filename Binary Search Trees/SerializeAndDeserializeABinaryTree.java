import java.util.*;
import java.io.*;

   public class SerializeAndDeserializeABinaryTree { 
     private static Node root;	
     private static Node previous;	
	
     public static String serialize(Node root) {	 
       if (root == null) {
	 return " ";
       }
	  
       StringBuilder result = new StringBuilder();
       Queue<Node> queue = new LinkedList<Node>();
       queue.add(root);
       while(!queue.isEmpty()) {
	 Node node = queue.poll();
	 if(node == null) {
	   result.append("null" + " ");
	   continue;
	 } 
	 result.append(node.data + " ");
       	 queue.add(node.left);
	 queue.add(node.right);
       }
	 
       return result.toString();				
     }
	
     public static Node deserialize(String data) {	 
       if (data == " ") {
	 return null;
       }
       Queue<Node> queue = new LinkedList<Node>();
       String values[] = data.split(" ");
       Node root = new Node(Integer.parseInt(values[0]));
       queue.add(root);
       for (int i = 1; i < values.length; i++) {
         Node parent = queue.poll();
         if (!values[i].equals("null")) {
           Node left = new Node(Integer.parseInt(values[i]));
           parent.left = left;
           queue.add(left);
         }
         if (!values[++i].equals("null")) {
           Node right = new Node(Integer.parseInt(values[i]));
           parent.right = right;
           queue.add(right);
         }
       }
	    
       return root;				
     }

     public static void main(String[] args) { 
       SerializeAndDeserializeABinaryTree tree = new SerializeAndDeserializeABinaryTree();
       tree.root = new Node(20);
       tree.root.left = new Node(8);
       tree.root.right = new Node(22);
       tree.root.left.left = new Node(4);
       tree.root.left.right = new Node(12);
       tree.root.left.right.left = new Node(10);
       tree.root.left.right.right = new Node(14);
	   
       String string = tree.serialize(tree.root);
       System.out.println(string);
       System.out.println();
       Node node = tree.deserialize(string);
       System.out.println(node);
       System.out.println();
     }
   }
