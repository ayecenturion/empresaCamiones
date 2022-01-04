package ort.edu.ar.clases;

import edu.ort.tp1.u5.tda.Cola;
import edu.ort.tp1.u5.tda.nodos.ColaNodos;

public class Camion {
	
	private String patente;
	private Cola<Paquete> paquetes;
	private static final int MAX_PAQUETES = 3;

	public Camion(String patente) {
		this.setPatente(patente);
		this.paquetes = new ColaNodos<>(MAX_PAQUETES);
	}
	
	

	public String getPatente() {
		return patente;
	}

	private void setPatente(String patente) {
		
		this.patente = patente;
	}



	public void agregarPaquete(Paquete paquete) {
		this.paquetes.add(paquete);
		System.out.println("paquete");
	}

	public double verTotal() {
		double total = 0;
		
		Paquete cent = new PaquetePeso("",0,0);
		this.paquetes.add(cent);
		Paquete actual = this.paquetes.remove();
		
		while(actual != cent) {
			total = total + actual.getPrecio();
		}
		
		return total;
	}



	public boolean verificarLugar() {
		boolean hayLugar = true;
		
		if(this.paquetes.isFull()) {
			hayLugar = false;
		}
		
		return hayLugar;
	}

}
