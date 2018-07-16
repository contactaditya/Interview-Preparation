import java.util.*;

  public class NArray {
	  
	public static ArrayList<Integer> repeatedNumber(final List<Integer> list) {
	  ArrayList<Integer> result = new ArrayList<Integer>();
	  Collections.sort(list);
	  int repeatedNumber = -1;
	  int missingInteger = -1;
	  long sum = list.get(0);
	  
	  for(int i = 1; i < list.size(); i++) {
	    if (list.get(i).intValue() == list.get(i - 1).intValue()) {
	      repeatedNumber = list.get(i);
	    }
        sum += list.get(i);
	  }
	  
	  missingInteger = (int) ((1L * list.size() * (1L * list.size() + 1)) / 2 - sum + repeatedNumber);

	  result.add(repeatedNumber);
	  result.add(missingInteger);
	 
	  return result;
	}
	
	public static ArrayList<Integer> repeatedNumber1(final List<Integer> list) {
	  ArrayList<Integer> result = new ArrayList<Integer>();
      List<Integer> B = new ArrayList<Integer>(list);
        
      int duplicated = -1;
      int indexOfMissing = -1;
      for (int i = 0; i < B.size(); i++) {
        // until B[i] stores the right number (i.e. i + 1) or we meet the duplicated number
        while (B.get(i) != i + 1)  {
          int number = B.get(i);

          if (number == B.get(B.get(i) -1)) {
            // met with duplicated number
            duplicated = B.get(number - 1);
            indexOfMissing = i;
            break;
          }
          // swap B[i] with B[num - 1]
          int temp = B.get(i);
          B.set(i, B.get(number - 1));
          B.set(number - 1, temp);
        }
      }
        
      result.add(duplicated);
      result.add(indexOfMissing + 1);
        
      return result;
	}	  

	public static void main(String[] args) { 	 
	  Scanner input = new Scanner(System.in);
      System.out.print("Enter number of elements in the list: ");
      int number = input.nextInt();  
      ArrayList<Integer> list = new ArrayList<Integer>();	
			
      System.out.println();	
      System.out.print("Please enter the elements of the list: ");
      for (int i = 0; i < number; i++) {
	    list.add(input.nextInt());
      }
      
      input.close();
		  		  
      ArrayList<Integer> result = new ArrayList<Integer>();
	  result = repeatedNumber(list);
	  System.out.println();
	  System.out.println("The integer that appears exactly twice and the integer which is missing in the list is: " + result);
	}
  }
