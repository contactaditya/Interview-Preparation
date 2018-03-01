import java.util.*;
import java.io.*;

  public class KeepCount {

   public static List<String> keepWithCount(List<String> list, int n) {
      List<String> result = new ArrayList<String>(); 
      Map<String, Integer> map = new HashMap<String, Integer>(); // map to store count of each string
         
      for (int i = 0; i < list.size(); i++) {
        if(map.containsKey(list.get(i))) {
          int get = map.get(list.get(i));
          map.put(list.get(i), get + 1);
        }
        else{
          map.put(list.get(i), 1);
        }
      }
            
      for (Map.Entry<String, Integer> it: map.entrySet()) {
        if(it.getValue() == n) {
          result.add(it.getKey());
        }
      }
                
	  return result;   
	}	  

    public static void main(String[] args) { 	
      Scanner input = new Scanner(System.in);
      System.out.print("Enter number of elements in the list: ");
      int number = input.nextInt();  
      List<String> list = new ArrayList<String>();	
 			
      System.out.println();	
	  input.nextLine();
      System.out.println("Please enter the elements of the list: ");
      for (int i = 0; i < number; i++) {
 	    list.add(input.nextLine());
      }
    
 	  System.out.println();
 	  System.out.print("Enter a positive integer n: ");
 	  int n = input.nextInt();  
 	   
 	  List<String> result = new ArrayList<String>();
 	   
 	  result = keepWithCount(list, n);
 	  System.out.println();
 	  System.out.print("The list of string that appear exactly " + n + " times in the list are: " + result);
    }
  }