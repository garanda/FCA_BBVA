package c2;

import java.util.Iterator;
import java.util.List;

import jade.core.behaviours.Behaviour;

public class B_Lista extends Behaviour {

	List<String> Lista;
	Iterator<String> it;
	public B_Lista(List<String> _tags) {
		super();
		Lista = _tags;
		it = Lista.iterator();
	}
	
	
	@Override
	public void action() {
		String etiqueta = it.next();
		System.out.println(etiqueta);
	}

	@Override
	public boolean done() {

		return !it.hasNext();
	}

}
