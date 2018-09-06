import java.util.*;
import java.util.*;
import java.util.Map.Entry;
import java.io.*;

  public class SortingElementsOfAnArrayByFrequency {
	  
    private static void sortElementsByFrequency(int array[]) {  
      Map<Integer, Integer> map = new HashMap<Integer, Integer>();	
      /* Logic to place the elements to Map */
      for(int i = 0; i < array.length; i++) {
        if(map.get(array[i]) == null) {
          map.put(array[i], 1);
        }
        else {
          int frequency = map.get(array[i]);
          map.put(array[i], frequency + 1);
        }
      }
       
      Set<Entry<Integer, Integer>> set = map.entrySet();
      List<Entry<Integer, Integer>> list = new ArrayList<Entry<Integer, Integer>>(set);
       
      /* Sort the list elements based on frequency */
      Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
	@Override
	public int compare(Entry<Integer, Integer> object1, Entry<Integer, Integer> object2) {
	  return object2.getValue().compareTo(object1.getValue());
	}
      });
      
      int count = 0;
      
      /* Place the elements in to the array based on frequency */
      for (Entry<Integer, Integer> entry : list) {
        int key = entry.getKey();
	int value = entry.getValue();
	            
	for(int i=0; i < value; i++) {
	  array[count] = key;
	  count++;
	}            
      } 
    }  
    
    private static void printArray(int[] array) {
      for (int i = 0; i < array.length; i++) {
   	System.out.print(array[i] + " ");
      }  
    }
	  
    public static void main(String[] args) {  
      Scanner input = new Scanner(System.in);
      System.out.print("Enter number of elements in the array: ");
      int numbers = input.nextInt();   
      int array[] = new int[numbers];
		    
      System.out.println();	
      System.out.print("Please enter the actual values in the array: ");
      for (int i = 0; i < numbers; i++) {
	array[i] = input.nextInt(); 
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
