package ort.edu.ar.clases;

public class PaquetePeso extends Paquete{
	private double peso;
	private double precioPeso;

	public PaquetePeso(String destino, double  peso, double precioPeso) {
		super(destino);
		this.peso = peso;
		this.precioPeso = precioPeso;
	}

	@Override
	public void calcularPrecio() {
		super.setPrecio(this.peso * this.precioPeso);
	}

}
