import java.util.*;
import java.io.*;

  public class Twitter {   
    private static int timeStamp=0;
    private Map<Integer, User> userMap; // easy to find if user exist
    
    class Tweet {
      int id;
      int time;
      Tweet next;
			   
      public Tweet(int id) {
	this.id = id;
	time = timeStamp++;
	next = null;
      }
    }  
	
    class User {
      int id;
      HashSet<Integer> followed;
      Tweet tweetHead;
	  
      public void follow(int id){
        followed.add(id);
      }

      public void unFollow(int id){
        followed.remove(id);
      }

      public void post(int id){
        Tweet tweet = new Tweet(id);
        tweet.next = tweetHead;
        tweetHead = tweet;
      }
				   
      public User(int id) {
	this.id = id;
	this.followed = new HashSet<Integer>();
	follow(id);
	tweetHead = null;
      }
    }  
	  
    /** Initialize your data structure here. */
    public Twitter() {
      userMap = new HashMap<Integer, User>();     
    }
	    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
      if(!userMap.containsKey(userId)) {
	User user = new User(userId);
	userMap.put(userId, user);
      }
      userMap.get(userId).post(tweetId);      
    }
	    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
      List<Integer> result = new ArrayList<Integer>();
      if(!userMap.containsKey(userId)) {
	return result;
      }
      HashSet<Integer> users = userMap.get(userId).followed;
      java.util.PriorityQueue<Tweet> queue = new java.util.PriorityQueue<Tweet>(users.size(), (a, b) -> (b.time - a.time));
      for(int user : users) {
        Tweet tweet = userMap.get(user).tweetHead;
        if(tweet != null) {
          queue.offer(tweet);
        }
      }
      int count = 0;
      
      while(!queue.isEmpty() && count < 10) {
        Tweet tweet = queue.poll();
        result.add(tweet.id);
        count++;

        if(tweet.next != null) {
          queue.offer(tweet.next);
        }
      }
		 
      return result;      
    }
	    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
      if(!userMap.containsKey(followerId)) {
	User user = new User(followerId);
	userMap.put(followerId, user);
      }  
	  
      if(!userMap.containsKey(followeeId)) {
	User user = new User(followeeId);
	userMap.put(followeeId, user);
      }  
      userMap.get(followerId).follow(followeeId);
    }
	    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
      if(!userMap.containsKey(followerId) || followerId == followeeId) {
	return;
      }

      userMap.get(followerId).unFollow(followeeId);     
    }

    public static void main(String[] args) throws NumberFormatException, IOException {  
      int choice = 0;
      Twitter twitter = new Twitter(); 
      do{	
	  System.out.println("1. To compose a new tweet.");
	  System.out.println("2. To retrieve the 10 most recent tweet ids in the user's news feed.");
	  System.out.println("3. To follow the followee.");
	  System.out.println("4. To unfollow the followee.");
	  System.out.println();	  	
	  System.out.print("Enter your choice: ");
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
	  choice = Integer.parseInt(br.readLine());
	  switch (choice) {
	    case 1:  System.out.println();
		     System.out.print("Enter the user ID of the tweet: ");
		     BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));  	
		     int userId = Integer.parseInt(br1.readLine());
		     System.out.println();	
		     System.out.print("Enter the tweet ID of the tweet: ");
		     int tweetId = Integer.parseInt(br1.readLine());
		     twitter.postTweet(userId, tweetId); 
		     break;
	    case 2:  System.out.println();
	  	     System.out.print("Enter the user ID of the tweet: ");
	  	     BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));  	
      	             int userId1 = Integer.parseInt(br2.readLine());
      	             List<Integer> result = new ArrayList<Integer>();
	             result = twitter.getNewsFeed(userId1);
	             System.out.println();		 
	             System.out.print("The 10 most recent tweet ids in the user's news feed are: " + result);
	             System.out.println();		 
	             break;
	    case 3:  System.out.println();
	  	     System.out.print("Enter the follower ID: ");
	  	     BufferedReader br3 = new BufferedReader(new InputStreamReader(System.in));  	
      	             int followerId = Integer.parseInt(br3.readLine());
      	             System.out.println();	
	  	     System.out.print("Enter the followee ID: ");
      	             int followeeId = Integer.parseInt(br3.readLine());	
	    	     twitter.follow(followerId, followeeId);
	             break;
	    case 4:  System.out.println();
	             System.out.print("Enter the follower ID: ");
	             BufferedReader br4 = new BufferedReader(new InputStreamReader(System.in));  	
  	             int followerId1 = Integer.parseInt(br4.readLine());
  	             System.out.println();	
  	             System.out.print("Enter the followee ID: ");
  	             int followeeId1 = Integer.parseInt(br4.readLine());
	             twitter.unfollow(followerId1, followeeId1);
	             break;
	  }
          System.out.println();
       } while(choice != 5);
     }
   }
  
