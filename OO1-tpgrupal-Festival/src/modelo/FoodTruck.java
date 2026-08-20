package modelo;


public class FoodTruck extends UnidadVenta{
	private String patente;
	private boolean requiereElectricidad;
	
	public FoodTruck(String nombreComercial, Empleado responsable,
					double superficie, String codigo, String patente, boolean requiereElectricidad) {
		super(nombreComercial,responsable,superficie,codigo);
		this.setPatente(patente);
		this.setRequiereElectricidad(requiereElectricidad);
	}

	public String getPatente() {
		return patente;
	}
	public void setPatente(String patente) {
		this.patente = patente;
	}
	public boolean isRequiereElectricidad() {
		return requiereElectricidad;
	}
	public void setRequiereElectricidad(boolean requiereElectricidad) {
		this.requiereElectricidad = requiereElectricidad;
	}
	
	@Override
	public String toString() {
		return super.toString() + " | Patente: " + this.getPatente()+
				"| Requiere Electricidad: " + this.isRequiereElectricidad()+
				" ]";
	}
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public double calcularCanon() {
		double canon = this.superficie * Constantes.COSTO_POR_M2;

	    if(this.requiereElectricidad)
	    {
	        canon += Constantes.PLUS_ELECTRICIDAD;
	    }

	    return canon;
	}
}
