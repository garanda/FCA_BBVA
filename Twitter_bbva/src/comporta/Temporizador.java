package comporta;


import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.TickerBehaviour;

public class Temporizador extends TickerBehaviour {

	String TAG;
	
	public Temporizador(Agent a, long period, String _tag) {
		super(a, period);
		TAG = _tag;
	}

	@Override
	protected void onTick() {

		ExtraeAdelante et = new ExtraeAdelante(TAG);
		myAgent.addBehaviour(et);
		
	}


}
