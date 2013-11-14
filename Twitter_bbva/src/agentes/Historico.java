package agentes;

import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

import c2.B_Hist;
import c2.B_Lista;

import comporta.ExtraeAdelante;
import comporta.ExtraeAtras;
import comporta.Temporizador;
import es.us.tad.Ficheros;

import util.Datos;

import jade.core.Agent;
import jade.content.lang.*;
import jade.lang.acl.ACLMessage;

@SuppressWarnings("serial")
public class Historico extends Agent {

	private List<String> Lista;
	
	
	protected void setup() {
		Datos.initDatos();
		
		
		Lista = new LinkedList<String>();
		Ficheros fet = new Ficheros("etiquetas.txt");
		
		String contenido = fet.LeerFichero();
		
		StringTokenizer st = new StringTokenizer(contenido);
		while (st.hasMoreTokens()) {
			String cad = st.nextToken();
			if (cad.charAt(0) !=';')					
				Lista.add(cad);
		}
		
		B_Hist b = new B_Hist(Lista,0,1);
		addBehaviour(b);
		
		
		
		
		
/*		
		
		Object[] arg = this.getArguments();
		if (arg.length<1)
			this.doDelete();

		Temporizador ba = new Temporizador(this,30000,(String)arg[0]);
		this.addBehaviour(ba);
*/	
		
	}
	
	
	
}
