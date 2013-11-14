package p1;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.conf.ConfigurationBuilder;

public class Ex2 {
	static String consumerKey      = "yWWCEhfdq8nEttG5c9jkGw";
	static String consumerSecret   = "KbFVvJ9tITu7CEcdahYcsclbu1I9BTUPuMHzZ1ZzM";

	static String accessToken      = "13162462-BDkw1UfutOQJ0iBKHJegS3zqucqDh36z0750abnjt";
	static String accessSecret     = "fiQJnCAw16KJixjeC8PBLc2AXsExvCQ07IrkGZCT8";
	/**
	 * @param args
	 * @throws TwitterException 
	 */
	public static void main(String[] args) throws TwitterException {
		

	    ConfigurationBuilder cb = new ConfigurationBuilder();
	    cb.setDebugEnabled(true).setOAuthConsumerKey(consumerKey)
	    		.setOAuthConsumerSecret(consumerSecret)
	    		.setOAuthAccessToken(accessToken)
	    		.setOAuthAccessTokenSecret(accessSecret);

		TwitterFactory tf = new TwitterFactory(cb.build());
		
//	    AccessToken at = new AccessToken(accessToken,accessSecret);

	    
	    Twitter twitter = tf.getInstance();

	    
	    
	    
	    Query query = new Query("botella");
	   
	    
	    QueryResult result = twitter.search(query);
	    
	    System.out.println(result.getCount() + "\n\n");
	    
	    
	    for (Status status : result.getTweets()) {
	        System.out.println("@" + status.getUser().getScreenName() + ":" + status.getGeoLocation() + " *-* " + status.getUser().getLocation() );
	    }

	}

}
