import java.util.*;
import java.util.Map.Entry;
import java.io.*;

  public class SortElementsByFrequency {  
	
    public static void sortElementsByFrequency(String[] array) {
      Map<String, Integer> map = new HashMap<String, Integer>();	
      /* Logic to place the elements to Map */
      for(int i = 0; i < array.length; i++) {
        if(map.get(array[i]) == null) {
          map.put(array[i], 1);
        }
        else {
          int frequency = map.get(array[i]);
          map.put(array[i], frequency+1);
        }
      }
		
      List<Entry<String, Integer>> list = new LinkedList<Entry<String, Integer>>(map.entrySet());
       
      /* Sort the list elements based on frequency */
      Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
	@Override
	public int compare(Entry<String, Integer> object1, Entry<String, Integer> object2) {
	  return object2.getValue().compareTo(object1.getValue());
	}
      });
       
      int count = 0;
       
      /* Place the elements in to the array based on frequency */
      for (Entry<String, Integer> entry : list) {
        String key = entry.getKey();
  	int value = entry.getValue();
  	            
  	for(int i = 0; i < value; i++) {
  	  array[count] = key;
  	  count++;
  	}
      }
    }	 
	 
    public static void printArray(String[] array) {
      for (int i = 0; i < array.length; i++) {
 	System.out.print(array[i] + " ");
      }  
    }	

    public static void main(String[] args) { 	   	  
      Scanner input = new Scanner(System.in);
      System.out.print("Enter number of elements in the array: ");
      int numbers = input.nextInt();   
      String array[] = new String[numbers];
		    
      System.out.println();
      input.nextLine();
      System.out.print("Please enter the actual values in the array: ");
      System.out.println();
      for (int i = 0; i < numbers; i++) {
	array[i] = input.nextLine(); 
      }
	 
      System.out.println();
      System.out.print("Array before sorting elements by frequency are: ");
      printArray(array);
	   
      sortElementsByFrequency(array);
	   
      System.out.println();
      System.out.println();
		
      System.out.print("Array after sorting elements by frequency are: ");		
      printArray(array);
    }
  }
