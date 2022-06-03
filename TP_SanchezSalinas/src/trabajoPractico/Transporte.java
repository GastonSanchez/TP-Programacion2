package trabajoPractico;

public abstract class Transporte {
	
	private String id;
	private double cargaMax;
	private double capacidadMax;
	private boolean refrigeracion;
	protected double costoKM;
	protected Destino dest;
	
	
	
	public Transporte(String id, double cargaMax, double capacidadMax, boolean refrigeracion, double costoKM, Destino dest) {
		this.id = id;
		this.cargaMax = cargaMax;
		this.capacidadMax = capacidadMax;
		this.refrigeracion = refrigeracion;
		this.costoKM = costoKM;
		this.dest=dest;
	}


	public abstract void asignarDestino(Destino dest);
	public abstract double calcularCostoViaje();
}
