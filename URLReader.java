import java.util.*;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

   public class URLReader {

     public static void main(String[] args) throws IOException {
       URL oracle = new URL("https://www.oracle.com/");
       BufferedReader input = new BufferedReader(new InputStreamReader(oracle.openStream()));

       String inputLine;
       while ((inputLine = input.readLine()) != null) {
	 System.out.println(inputLine);
       }
       input.close();
     }
   }
