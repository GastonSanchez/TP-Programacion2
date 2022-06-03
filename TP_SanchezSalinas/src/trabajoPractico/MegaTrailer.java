package trabajoPractico;

public class MegaTrailer extends Transporte {

	private double seguroCarga;
	private double costoFijo;
	private double costoComida;
	
	public MegaTrailer(String patente, double cargaMax, double capacidadMax, boolean refrigerado, double costoKM, Destino dest, double seguroCarga,double costoFijo, double costoComida) {
		super(patente, cargaMax, capacidadMax, refrigerado, costoKM, dest);
		this.seguroCarga = seguroCarga;
		this.costoFijo = costoFijo;
		this.costoComida = costoComida;
	}

	@Override
	public double calcularCostoViaje() {
		double costoFinal;
		return costoFinal = (dest.getDistancia() * costoKM) + seguroCarga + costoFijo + costoComida;
	}
	
	public void asignarDestino(Destino dest) {
		this.dest = dest;
	}

	@Override
	public String tipoDeTransporte() {
		return "MegaTrailer";
	}
	
}
