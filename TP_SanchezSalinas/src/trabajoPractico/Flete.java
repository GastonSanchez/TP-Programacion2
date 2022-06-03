package trabajoPractico;

public class Flete extends Transporte{

	private int pasajeros;
	private double costoPasajero;
	
	public Flete (String patente, double cargaMax, double capacidadMax, double costoKM, Destino dest, int pasajeros, double costoPasajero) {
		super(patente, cargaMax, capacidadMax, false, costoKM, dest);
		this.pasajeros = pasajeros;
		this.costoPasajero = costoPasajero;
	}
	
	@Override
	public double calcularCostoViaje() {
		double costoFinal;
		return costoFinal = (dest.getDistancia() * costoKM) + (pasajeros*costoPasajero);
	}
	
	public void asignarDestino(Destino dest) {
		this.dest = dest;
	}
	
}
