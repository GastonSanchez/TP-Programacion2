package trabajoPractico;

public class Paquete {
	
	private String destino;
	private double peso;
	private double volumen;
	private boolean refrigerado;

	public Paquete(String destino, double peso, double volumen, boolean refrigerado) {
		this.peso = peso;
		this.volumen = volumen;
		this.destino = destino;
		this.refrigerado = refrigerado;
	}

	public boolean esRefrigerado() {
		return this.refrigerado;
	}
	
	

	public double getVolumen() {
		return volumen;
	}

	@Override
	public String toString() {
		return "Destino:" + destino + ", Peso:" + peso + ", Volumen:" + volumen + "\n";
	}
	
	
}
