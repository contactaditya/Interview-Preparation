import java.util.*;
import java.io.*;

 public class ReadingATextFileInJava {

	public static void main(String[] args) throws FileNotFoundException, IOException {
	   Scanner input = new Scanner(System.in);
	   String fileName = new String();	  
	   String contentLine = null;
	   System.out.print("Please enter the path of the file that you want to read: ");	
	   fileName = input.next();  

       // FileReader reads text files in the default encoding of the system.
       FileReader fileReader = new FileReader(fileName);

       // Always wrap FileReader in BufferedReader.
       BufferedReader bufferedReader = new BufferedReader(fileReader);
       
       System.out.println();
       while((contentLine = bufferedReader.readLine()) != null) {
          System.out.println(contentLine);
       }   

       bufferedReader.close();  
       input.close();
	}
 }
