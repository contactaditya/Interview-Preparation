import java.util.*;
import java.io.*;

 public class ConvertSortedListToBinarySearchTree {
    private static LinkedListNode head;
    private static int size;  
    private static Node root;	    
	
    public ConvertSortedListToBinarySearchTree() {
       // this is an empty list, so the reference to the head node is set to a new node with no data				  
       head = new LinkedListNode(null);
       size = 0;
    }
	 
    public Node sortedListToBST(LinkedListNode head) {
       if (head == null) {
	 return null;
       }	
			
       return toBST(head, null);          
    }	 

    private Node toBST(LinkedListNode head, LinkedListNode tail) {
       LinkedListNode slow = head;
       LinkedListNode fast = head;
	   
       if(head==tail) {
	  return null;
       }
	   
       while(fast!=tail&&fast.next!=tail){
	 fast = fast.next.next;
	 slow = slow.next;
       }
	   
       // Slow here represents the middle of the linked list.
	   
       Node root = new Node((int)slow.data);
       root.left = toBST(head,slow);
       root.right = toBST(slow.next,tail);
       return root;
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
       ConvertSortedListToBinarySearchTree list = new ConvertSortedListToBinarySearchTree();
       list.head = new LinkedListNode(1);
       list.head.next = new LinkedListNode(2);
       list.head.next.next = new LinkedListNode(3);
       list.head.next.next.next = new LinkedListNode(4);
       list.head.next.next.next.next = new LinkedListNode(5);
       list.head.next.next.next.next.next = new LinkedListNode(6);
       list.head.next.next.next.next.next.next = new LinkedListNode(7);
		  	 
       Node node = list.sortedListToBST(head);
       System.out.print("Inorder traversal of constructed tree is: ");
       printInorderTraversal(node);		

    }
 }
