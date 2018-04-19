import java.util.*;
import java.io.*;

   class LinkedListNode1 {
     public Object data; 
     public LinkedListNode1 right;
     public LinkedListNode1 down;

     //Node constructor
		    
     public LinkedListNode1(Object data) {
	this.data = data;
	right = null;
	down = null;
     }
		    
     public LinkedListNode1(Object data, LinkedListNode1 right, LinkedListNode1 down) {
	this.data = data;
	this.right = right;
	this.down = down;
     }
	 
     public Object getData() {
	return data;
     }
			
     public void setData(Object data) {
	this.data = data; 
     }
			
     public LinkedListNode1 getRight() {
	return right;
     }
			
     public void setRight(LinkedListNode1 right) {
	this.right = right;
     }
	 
     public LinkedListNode1 getDown() {
        return down;
     }
				 
     public void setDown(LinkedListNode1 down) {
	this.down = down;
     }
   }

   public class FlatteningALinkedList {
     private static LinkedListNode1 head;
     private static int size;  
    
     public static LinkedListNode1 flatten(LinkedListNode1 root) {
       // Base Cases
       if (root == null || root.right == null) {
          return root;
       }
	   	
       // Recurse for the list on right
       root.right = flatten(root.right);
       
       // now merge
       root = MergeLists(root, root.right);
    	
       return root;
     }
    
     public static LinkedListNode1 MergeLists(LinkedListNode1 headA, LinkedListNode1 headB) {
       LinkedListNode1 list = headA;
       LinkedListNode1 list1 = headB;
 	       
       if (list == null && list1 == null) {
 	 return null; 
       }
 	   
       // If first linked list is empty then second linked list is the answer
       if (list == null) {
 	 return list1; 
       }
 	   
       // If second linked list is empty then first linked list is the answer
       if (list1 == null) {
 	 return list;
       }
 	   
       // Compare the data members of the two linked lists and put the larger one in the result
       LinkedListNode1 result;

       if ((int)list.data < (int)list1.data) {
 	 result = list;  
 	 list.down = MergeLists(list.down, list1);
       } else {
         result = list1;  
 	 list1.down = MergeLists(list1.down, list);
       }
 	   
       return result;
     }
    
     public static void PrintElementsOfALinkedList(LinkedListNode1 head) {	 
       LinkedListNode1 current = head; 
       while(current != null) {	   
	 System.out.print(current.getData() + " ");	 	
         current = current.down;
       }
     } 		

     public static void main(String[] args) {
       FlatteningALinkedList list = new FlatteningALinkedList();
       list.head = new LinkedListNode1(5);
       list.head.down = new LinkedListNode1(7);
       list.head.down.down = new LinkedListNode1(8);
       list.head.down.down.down = new LinkedListNode1(30);
       list.head.right = new LinkedListNode1(10);
       list.head.right.down = new LinkedListNode1(20); 	   
       list.head.right.right = new LinkedListNode1(19);
       list.head.right.right.down = new LinkedListNode1(22); 	 
       list.head.right.right.down.down = new LinkedListNode1(50); 	 
       list.head.right.right.right = new LinkedListNode1(28);
       list.head.right.right.right.down = new LinkedListNode1(35);
       list.head.right.right.right.down.down = new LinkedListNode1(40);
       list.head.right.right.right.down.down.down = new LinkedListNode1(45);
 	 	  		  
       list.flatten(head);
		  
       System.out.print("Linked List after flattening is: ");	 
       list.PrintElementsOfALinkedList(head);
     }
   }
