package trabajoPractico;

public abstract class Transporte {

	private String id;
	private double cargaMax;
	private double capacidadMax;
	private boolean refrigeracion;
	protected double costoKM;
	protected Destino dest;
	private boolean enViaje;
	private double cargaActual;

	public Transporte(String id, double cargaMax, double capacidadMax, boolean refrigeracion, double costoKM,
			Destino dest) {
		this.id = id;
		this.cargaMax = cargaMax;
		this.capacidadMax = capacidadMax;
		this.refrigeracion = refrigeracion;
		this.costoKM = costoKM;
		this.dest = dest;
		this.enViaje = false;
		this.cargaActual = 0;
	}

	public Destino getDest() {
		return dest;
	}

	public abstract void asignarDestino(Destino dest);

	public abstract double calcularCostoViaje();

	public abstract String tipoDeTransporte();

	protected void iniciarViaje() {
		if (this.enViaje || this.cargaActual <= 0) {
			throw new RuntimeException("El Transporte ya se encuentra en viaje!");
		} else {
			this.enViaje = true;
		}
	}

	protected void finalizarViaje() {
		if (this.enViaje) {
			this.enViaje = false;
			this.dest = null;
			this.cargaActual = 0;
		} else {

			throw new RuntimeException("El Transporte no se encuentra en viaje!");
		}
	}

	public boolean esRefrigerado() {
		return this.refrigeracion;
	}

	public double cargar(Deposito depoRefrigerado) {
		for (Paquete paquete : depoRefrigerado.getInventario()) {
			if (this.dest == paquete.getDestino()) {
				cargarTransporte(paquete);
			}
		}
		return this.cargaActual;
	}

	protected void cargarTransporte(Paquete paquete) {
		if (this.capacidadMax >= cargaActual + paquete.getVolumen()) {
			this.cargaActual += paquete.getVolumen();
		}
	}

	public double getCargaActual() {
		return cargaActual;
	}

	public String getId() {
		return id;
	}
	
	
}
