import java.util.*;
import java.io.*;

 class Node1 {
    char character;
    int value;
    Node1 left, mid, right;
    
    public Node1() {}
    
    public Node1(char character) {
      this.character = character;
      this.value = 0;
    } 
 }

  public class ShortestUniquePrefixToRepresentEachWord1 {
    private static Node1 root;
	 
    public static ArrayList<String> prefix(ArrayList<String> a) {
       if (a == null || a.size() <= 0) {
	  return null;    
       }	
       ArrayList<String> result = new ArrayList<>();
       for (String word : a) {
	 put(word);
       }
       for (String word : a) {
	  String prefix = getPrefix(word);
	  result.add(prefix);
       }
      return result;
    }	
	
   public static String getPrefix(String string) {
      StringBuilder prefix = new StringBuilder();
      return get(root, string, 0, prefix);
   }
	
   public static String get(Node1 node, String string, int index, StringBuilder prefix) {
	    
      char c = string.charAt(index);
	    
      if (c < node.character) {
	 return get(node.left, string, index, prefix);
      } else if (c > node.character) {
	 return get(node.right, string, index, prefix);
      } else if (node.value == 1) {
	 prefix.append(node.character);
	 return prefix.toString();
      } else {
	 prefix.append(node.character);
	 return get(node.mid, string, index + 1, prefix);
      }
   }
	
   public static void put(String string) {
      root = put(root, string, 0);
   } 
	
   public static Node1 put(Node1 node, String string, int index) {
	    
      if (index == string.length()) {
	 return node;
      }
	    
      if (node == null) {
	 node = new Node1(string.charAt(index));
      }
	    
      char c = string.charAt(index);
	    
      if (c < node.character) {
	 node.left = put(node.left, string, index);
      } else if (c > node.character) {
	 node.right = put(node.right, string, index);
      } else {
	 node.mid = put(node.mid, string, index + 1);
	 node.value += 1;
      }
	    
      return node;
   }

   public static void main(String[] args) {   
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the number of words in the list: ");
      int numberOfWords = input.nextInt();
      System.out.println();
      input.nextLine();
      System.out.println("Please enter the actual words in the list: ");
      ArrayList<String> X = new ArrayList<String>();
      for (int i = 0; i < numberOfWords; i++) {
	 X.add(input.nextLine());
      }		  
      List<String> result = new ArrayList<String>();
      result = prefix(X);
      System.out.println();
      System.out.println("The solution set with unique prefix is: " + result);
	  
   }
 }
