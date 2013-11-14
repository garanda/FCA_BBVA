package agentes;

import comporta.ExtraeAdelante;
import comporta.ExtraeAtras;
import comporta.TempoAtras;

import util.Datos;

import jade.core.Agent;

@SuppressWarnings("serial")
public class Trasero extends Agent {

	protected void setup() {

		Datos.initDatos();
		Object[] arg = this.getArguments();
		if (arg.length<1)
			this.doDelete();

//		TempoAtras ed = new TempoAtras(this,30000,(String)arg[0]);
//		addBehaviour(ed);
		System.out.println("Relanzar busqueda");
		addBehaviour(new ExtraeAtras((String)arg[0],-1));
		
	}
	
	
	
}
