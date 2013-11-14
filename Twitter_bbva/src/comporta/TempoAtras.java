package comporta;


import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;

@SuppressWarnings("serial")
public class TempoAtras extends TickerBehaviour {

	String TAG;
	
	public TempoAtras(Agent a, long period, String _tag) {
		super(a, period);
		TAG = _tag;
		
	}

	@Override
	protected void onTick() {

		ExtraeAtras et = new ExtraeAtras(TAG,-1);
		myAgent.addBehaviour(et);
		
	}


}
