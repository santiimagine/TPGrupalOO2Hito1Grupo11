package modelo;

public class PuestoDesarmable extends UnidadVenta {
	private int cantidadCarpas;
	private int tiempoMontaje;
	
	public PuestoDesarmable(String nombreComercial,
							Empleado responsable, double superficie,
							String codigo,int cantidadCarpas, 
							int tiempoMontaje) {
		super(nombreComercial,responsable,superficie,codigo);
		this.setCantidadCarpas(cantidadCarpas);
		this.setTiempoMontaje(tiempoMontaje);
		
	}

	public int getCantidadCarpas() {
		return cantidadCarpas;
	}
	public void setCantidadCarpas(int cantidadCarpas) {
		this.cantidadCarpas = cantidadCarpas;
	}
	public int getTiempoMontaje() {
		return tiempoMontaje;
	}
	public void setTiempoMontaje(int tiempoMontaje) {
		this.tiempoMontaje = tiempoMontaje;
	}
	
	@Override
	public String toString() {
		return super.toString()+" | Cantidad Carpas: " + this.getCantidadCarpas()+
				" | Tiempo Montaje: " + this.getTiempoMontaje()+
				" ]";
	}
	
	
	@Override
	public double calcularCanon() {
		return (this.superficie * Constantes.COSTO_POR_M2)
	            -
	           (this.tiempoMontaje * Constantes.COSTO_POR_MONTAJE_POR_MIN); 
	}
}
