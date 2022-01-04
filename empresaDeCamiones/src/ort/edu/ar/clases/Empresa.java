package ort.edu.ar.clases;

public class Empresa implements Detallable{

	private String nombre;
	private Camion[] camiones;
	private String[][] direccionesPaquete;
	private ListaPaquetesPr listaPrecios;
	private static final int MAX_PAQUETES = 3;
	private static final String MSG_CAMIONES = "NO PUEDES AGREGAR MAS CAMIONES";
	private static final String MSG_PATENTE_REP = "Patente repetida";
	private static final String MSG_CAMIONES_LLENOS = "TODOS LOS CAMIONES ESTAN LLENOS. NO PUEDE AGREGAR PAQUETES";
	
	public Empresa(String nombre, int cantCamiones) {
		this.nombre = nombre;
		this.camiones = new Camion[cantCamiones];
		this.direccionesPaquete = new String[cantCamiones][MAX_PAQUETES];
		this.listaPrecios = new ListaPaquetesPr();
	}
	
	

	public void agregarCamion(String patente) throws RuntimeException{
		int posLibre = obtenerPosLibre();
		
		if(posLibre == -1) {
			throw new RuntimeException(MSG_CAMIONES);
		}else {
			if(posLibre >= 0) {
				this.camiones[posLibre] = new Camion(patente);
			}else {
				Camion camion = verificarPatenteRepetida(patente);
				if(camion != null) {
					throw new RuntimeException(MSG_PATENTE_REP);
				}else {
					this.camiones[posLibre] = new Camion(patente);
				}
			}
			
		}
	}

	private Camion verificarPatenteRepetida(String patente) {
		Camion c = null;
		int i = 0;
		
		while(i<this.camiones.length && c == null) {
			if(this.camiones[i].getPatente().equalsIgnoreCase(patente)) {
				c = this.camiones[i];
			}else {
				i++;
			}
		}
		
		return c;
	}



	private int obtenerPosLibre() {
		int pos = -1;
		int i = 0;
		boolean libre = false;
		
		while(i<this.camiones.length && !libre) {
			if(this.camiones[i] == null) {
				libre = true;
				pos = i;
			}else {
				i++;
			}
			
			
		}
		
		return pos;
	}



	public void agregarPaquete(Paquete paquete) {
		int i = 0;
		boolean hayLugar = false;
		
		for (int j = 0; j < camiones.length; j++) {
			if(this.camiones[j].verificarLugar()) {
				hayLugar = true;
				this.camiones[j].agregarPaquete(paquete);
				this.listaPrecios.add(paquete);
			}else {
				throw new RuntimeException(MSG_CAMIONES_LLENOS);
			}
		}
	}

	public void verPaquetes() {
		System.out.println("Detalle de paquetes a enviar:");
		for (Paquete p : this.listaPrecios) {
			System.out.println("Destino: " + p.getDestino() + " $ " + p.getPrecio());
		}
	}

	public void camionMenorGanancias() {
		Camion menor = calcularMenor();
		
		System.out.println("El camión con menos ganancias es el de patente: " + menor.getPatente() + ", con $ " + menor.verTotal());
		
	}

	private Camion calcularMenor() {
		
		Camion cMenor = null;
		double menor = 99999;
		
		for (Camion camion : camiones) {
			double precio = camion.verTotal();
			if(precio<menor) {
				menor = precio;
				cMenor = camion;
			}
			
		}
		return cMenor;
	}



	@Override
	public void verDetalle() {
		this.verPaquetes();
		//this.camionMenorGanancias();
		
	}

}
