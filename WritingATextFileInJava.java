import java.util.*;
import java.io.*;

 public class WritingATextFileInJava {

	public static void main(String[] args) throws FileNotFoundException, IOException {
	  Scanner input = new Scanner(System.in);
	  String fileName = new String();	  
	  System.out.print("Please enter the path of the file that you want to write: ");	
	  fileName = input.next();  

	  // FileWriter reads text files in the default encoding of the system.
	  FileWriter fileWriter = new FileWriter(fileName);

	  // Always wrap FileWriter in BufferedWriter.
	  BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
	       
	  System.out.println();
	  bufferedWriter.write("Hi, Today is a sunny day.");
      bufferedWriter.newLine();
      bufferedWriter.newLine();
      bufferedWriter.write("I enjoy programming.");

	  bufferedWriter.close();   
	  input.close();

	}
 }
