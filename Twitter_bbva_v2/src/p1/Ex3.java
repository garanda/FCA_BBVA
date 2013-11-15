package p1;

import java.util.Iterator;

import twitter4j.GeoLocation;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class Ex3 {
	static String consumerKey      = "yWWCEhfdq8nEttG5c9jkGw";
	static String consumerSecret   = "KbFVvJ9tITu7CEcdahYcsclbu1I9BTUPuMHzZ1ZzM";

	static String accessToken      = "13162462-BDkw1UfutOQJ0iBKHJegS3zqucqDh36z0750abnjt";
	static String accessSecret     = "fiQJnCAw16KJixjeC8PBLc2AXsExvCQ07IrkGZCT8";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	    ConfigurationBuilder cb = new ConfigurationBuilder();
	    cb.setDebugEnabled(true).setOAuthConsumerKey(consumerKey)
	    		.setOAuthConsumerSecret(consumerSecret)
	    		.setOAuthAccessToken(accessToken)
	    		.setOAuthAccessTokenSecret(accessSecret);

		TwitterFactory tf = new TwitterFactory(cb.build());
		
//	    AccessToken at = new AccessToken(accessToken,accessSecret);

	    
	    Twitter twitter = tf.getInstance();


        try {
            GeoLocation geo = new GeoLocation(40.42,-3.67); // Madrid
            Query query1 = new Query();
            ///query1.setGeoCode(geo,150,"km");
            query1.setQuery("bbva");
            query1.setSince("2012-10-01");
            query1.setUntil("2013-11-10");
            query1.setCount(100);
            
//            query1.setResultType("recent");
            
                long n=0;
                QueryResult result1 = null;
                try {
                	result1 = twitter.search(query1);
                	
                	
                	int contador = 1;
                    boolean pagina = true;
                    while (pagina) {
                        
		                for (Iterator<Status> it = result1.getTweets().iterator(); it.hasNext();) {
		                	Status tweet3 = it.next();
		                	//if (tweet3.getGeoLocation() != null) {
		                		System.out.print(contador++ + "  - ");
		                		System.out.println(tweet3.getText() + "\n\t --> " + tweet3.getGeoLocation() + "\n\t --> " + tweet3.getCreatedAt() + "\n\n");
		                	//}
		                }
		                
		                if (result1.hasNext()) {
		                	query1 = result1.nextQuery();
		                	result1 = twitter.search(query1); 
		                	System.out.println("Pagina sigiuente");
		                }
		                else
		                	pagina=false;

		               
                    }
                }
                
                
                
                
                
                catch (TwitterException e) {
                    if (e.exceededRateLimitation()&& e.getStatusCode() == 503) {
                        System.out.println("Retry limit hit sleeping " + e.getRetryAfter() + " seconds");
                        Thread.sleep(e.getRetryAfter()*1000);
                    } else
                    	e.printStackTrace();
                    System.exit(-1);
                }
            }
        catch(Exception e) {
            e.printStackTrace();
        }


	}

}
