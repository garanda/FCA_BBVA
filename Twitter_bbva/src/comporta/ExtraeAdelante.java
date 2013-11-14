package comporta;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Tweet;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import util.Datos;
import jade.core.behaviours.Behaviour;

public class ExtraeAdelante extends Behaviour {

	String TAG = "";
	int Pagina = 1;
	int Resultados = 0;
    Twitter twitter;
    Query query;
	
	public ExtraeAdelante(String _tag) {
		super();
		TAG = _tag;
		Pagina = 1;
		Resultados = 0;
	    twitter = new TwitterFactory().getInstance();
	    query = new Query(TAG);
	    query.setRpp(Datos.ResultadoPP);
	    long valor = Datos.ultimoId(TAG);
	    if (valor>=0) 
	    	query.setSinceId(valor);

	    System.out.println("busqueda "+ TAG + "   DESDE: " + valor);
	    
	    
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
	    	return true;
	    }
		if ((Pagina == 15))  {
			System.out.println("Relanzar busqueda");
			myAgent.addBehaviour(new ExtraeAdelante(TAG));
			return true;
		}


		
		// TODO Auto-generated method stub
		return false;
	}

}
