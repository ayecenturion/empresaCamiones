package ort.edu.ar.clases;

public class PaqueteDistancia extends Paquete{
	private double distancia;
	private double precioDistancia;

	public PaqueteDistancia(String destino, double distancia, double precioDistancia) {
		super(destino);
		this.distancia = distancia;
		this.precioDistancia = precioDistancia;
	}

	@Override
	public void calcularPrecio() {
		super.setPrecio(this.distancia * this.precioDistancia);
		
	}

}
