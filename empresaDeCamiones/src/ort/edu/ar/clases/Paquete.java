package ort.edu.ar.clases;

public abstract class Paquete {
	
	protected double precio;
	private String destino;
	
	public Paquete(String destino) {
		this.setDestino(destino);
		
		
	}
	
	

	public String getDestino() {
		return destino;
	}



	private void setDestino(String destino) {
		this.destino = destino;
	}



	public double getPrecio() {
		return precio;
	}

	protected void setPrecio(double precio) {
		this.precio = precio;
	}


	public abstract void calcularPrecio();

}
