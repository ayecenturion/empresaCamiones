package ort.edu.ar.clases;

import edu.ort.tp1.u5.tda.nodos.ListaOrdenadaNodos;

public class ListaPaquetesPr extends ListaOrdenadaNodos<Double, Paquete>{

	@Override
	public double compare(Paquete dato1, Paquete dato2) {
		
		return dato2.getPrecio() - dato1.getPrecio();
	}

	@Override
	public int compareByKey(Double clave, Paquete elemento) {
		
		return (int) (clave-elemento.getPrecio());
	}

}
