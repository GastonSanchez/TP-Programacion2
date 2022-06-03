package trabajoPractico;

public class Trailer extends Transporte {
	private double seguroCarga;

	
	public Trailer(String patente, double cargaMax, double capacidadMax, boolean refrigerado, double costoKM,Destino dest, double seguroCarga) {
		super(patente, cargaMax, capacidadMax, refrigerado, costoKM, dest);
		this.seguroCarga = seguroCarga;
	}


	public double calcularCostoViaje() {
		
		double costoFinal;
		return costoFinal = (dest.getDistancia() * costoKM) + seguroCarga;
		
	}

	public void asignarDestino(Destino dest) {
		this.dest = dest;
	}

}
