package comporta;

import java.sql.SQLException;
import java.util.Date;

import twitter4j.Tweet;
import util.Datos;
import jade.core.behaviours.OneShotBehaviour;

@SuppressWarnings("serial")
public class GrabarTweet extends OneShotBehaviour {

	Tweet TWEET;
	String ETIQUETA;
	
	public GrabarTweet(Tweet _tweet, String _etiq) {
		super();
		TWEET = _tweet;
		ETIQUETA = _etiq;
	}
	
	@Override
	public void action() {
   	
		Date d = TWEET.getCreatedAt();
		String fechita = d.getYear() + "/"  +d.getMonth() + "/" + d.getDay() + " " + d.getHours() + ":" + d.getMinutes() + ":" + d.getSeconds();
		
//    	String cadena = "insert into mensajes (mensaje_id, usuario, usuario_id,texto,localizacion,fuente,a_usuario,a_usuario_id,completo,etiqueta,fecha) " +
//		"VALUES (?,?,?,?,?,?,?,?,?,?,'" + d.toString() + "')";
    	String cadena = "insert into mensajes (mensaje_id, usuario, usuario_id,texto,localizacion,fuente,a_usuario,a_usuario_id,completo,etiqueta) " +
		"VALUES (?,?,?,?,?,?,?,?,?,?)";

//    	System.out.println(cadena);
    	
    	try {
        	Datos.stmt = Datos.conexion.prepareStatement(cadena);

        	Datos.stmt.setLong(1, TWEET.getId());
        	Datos.stmt.setString(2, TWEET.getFromUser());
        	Datos.stmt.setLong(3,TWEET.getFromUserId());
        	Datos.stmt.setString(4,TWEET.getText());
        	Datos.stmt.setString(5, TWEET.getLocation());
        	Datos.stmt.setString(6, TWEET.getSource());
        	Datos.stmt.setString(7, TWEET.getToUser());
        	Datos.stmt.setLong(8, TWEET.getToUserId());
        	Datos.stmt.setString(9, TWEET.toString());
        	Datos.stmt.setString(10, ETIQUETA);
	       // Datos.stmt.setDate(11, new Date(TWEET.getCreatedAt().getYear(),TWEET.getCreatedAt().getMonth(),TWEET.getCreatedAt().getDay()));
	        
        	Datos.stmt.executeUpdate();

        	//System.out.println(TWEET.toString());
        	
        	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
//			System.out.println( "ERROR num: " + e.getErrorCode());
			
			
			//e.printStackTrace();
		}

	}

}
