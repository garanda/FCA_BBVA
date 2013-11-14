package p1;


import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class Extraccion1 {

	
	static Twitter twitter;
    static Query query;

    static int Resultados = 0;
    
    
    
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
	    twitter = new TwitterFactory().getInstance();
	    
	    twitter.setOAuthConsumer("yWWCEhfdq8nEttG5c9jkGw", "KbFVvJ9tITu7CEcdahYcsclbu1I9BTUPuMHzZ1ZzM");
        twitter.setOAuthAccessToken(new AccessToken("13162462-BDkw1UfutOQJ0iBKHJegS3zqucqDh36z0750abnjt", "fiQJnCAw16KJixjeC8PBLc2AXsExvCQ07IrkGZCT8"));
        
	    query = new Query("15m");
	    
	    try {
//	    	query.set
//	    	query.setPage(1);
	    	QueryResult result;
			result = twitter.search(query);
			Resultados = result.getTweets().size();
			
//			for (Tweet tweet : result.getTweets())
//				System.out.println(tweet);
	    } catch (TwitterException e) {
	    	e.printStackTrace();
		}

	    
	    


	}

}
