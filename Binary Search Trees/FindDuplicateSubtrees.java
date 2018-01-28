import java.util.*;
import java.io.*;

  public class FindDuplicateSubtrees { 
	private static Node root;	  
	private static int t;
	private static Map<String, Integer> trees;
	private static Map<Integer, Integer> count;
	private static List<Node> answer;
	  
	public static List<Node> findDuplicateSubtrees(Node root) {
	  t = 1;
	  trees = new HashMap();
	  count = new HashMap();
	  answer = new ArrayList();
	  lookup(root);
	  return answer;  
	}	 
	
	public static int lookup(Node node) {
	  if (node == null) {
		return 0;
	  }
	  String serial = node.data + "," + lookup(node.left) + "," + lookup(node.right);
	  int uid = trees.computeIfAbsent(serial, x-> t++);
	  count.put(uid, count.getOrDefault(uid, 0) + 1);
	  if (count.get(uid) == 2) {
		answer.add(node);
	  }
	  
	  return uid;
	}	

	public static void main(String[] args) {  
	  FindDuplicateSubtrees tree = new FindDuplicateSubtrees();
      tree.root = new Node(1);
      tree.root.left = new Node(2);
      tree.root.right = new Node(3);
      tree.root.left.left = new Node(4);
      tree.root.right.right = new Node(4);
      tree.root.right.left = new Node(2);
      tree.root.right.left.left = new Node(4);
	        
      List<Node> result = findDuplicateSubtrees(tree.root);		
      System.out.print("The root node of all the duplicate subtrees in the binary tree is: ");
      for (int i = 0; i < result.size(); i++) {
        System.out.print(result.get(i).data + " ");
      }
	
    }
  }
