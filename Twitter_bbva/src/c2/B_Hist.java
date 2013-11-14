package c2;

import java.util.List;

import comporta.GrabarTweet;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Tweet;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import util.Datos;
import jade.core.behaviours.Behaviour;

public class B_Hist extends Behaviour {

	List<String> Lista;
	int Indice=0;
	String TAG = "";
	int Pagina = 1;
	int Resultados = 0;
    Twitter twitter;
    Query query;
	
	public B_Hist(List<String> _tags, int _indice, int inicial) {
		super();
		Lista = _tags;
		TAG = _tags.get(_indice);
		
		Pagina = 1;
		Resultados = 0;
	    twitter = new TwitterFactory().getInstance();
	    query = new Query(TAG);
	    query.setRpp(Datos.ResultadoPP);
	    long valor = -1L;
	    if (inicial>0) {
	    	valor = Datos.primerId(TAG);
	    	if (valor>=0) 
	    		query.setMaxId(valor);
	    }
	    System.out.println(TAG + " -- busqueda   HASTA: " + valor);
	    

	}
	
	@Override
	public void action() {
		
		try {
		    query.setPage(Pagina);
		    QueryResult result;
		    result = twitter.search(query);
		    Resultados = result.getTweets().size();
				
		    for (Tweet tweet : result.getTweets())
		    	myAgent.addBehaviour(new GrabarTweet(tweet,TAG));
		    
		    Pagina++;
		    
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public boolean done() {
		System.out.println(TAG + " -- pagina: " + Pagina + "   -- Res: " + Resultados);

		if (Resultados < Datos.ResultadoPP) {
			System.out.println("Relanzar busqueda");
			myAgent.addBehaviour(new B_Hist(Lista,Indice+1,-1));
			return true;
			
		}
		
		
		if ((Pagina == 15))  {
			System.out.println("Relanzar busqueda");
			myAgent.addBehaviour(new B_Hist(Lista,Indice,1));
			return true;
		}


		
		// TODO Auto-generated method stub
		return false;
	}

}
