package agentes;

import comporta.ExtraeAdelante;
import comporta.ExtraeAtras;
import comporta.Temporizador;

import util.Datos;

import jade.core.Agent;

@SuppressWarnings("serial")
public class Delantero extends Agent {

	protected void setup() {

		Datos.initDatos();
		Object[] arg = this.getArguments();
		if (arg.length<1)
			this.doDelete();

		Temporizador ba = new Temporizador(this,30000,(String)arg[0]);
		this.addBehaviour(ba);
		
		
	}
	
	
	
}
