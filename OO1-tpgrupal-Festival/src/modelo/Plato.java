package modelo;

public class Plato {
	private int idPlato;
	private String nombre;
	private double precioVenta;
	private double costoProduccion;

	public Plato() {}

	//CONSTRUCTOR
	public Plato(String nombre, double precioVenta, double costoProduccion) {
		this.nombre = nombre;
		this.precioVenta = precioVenta;
		this.costoProduccion = costoProduccion;
	}

	//GETTERS Y SETTERS
	public int getIdPlato() {
		return idPlato;
	}

	// siempre va protected, para que no sea modificado desde afuera
	protected void setIdPlato(int id) {
		this.idPlato = id;
	}

	public String getNombre() {
		return nombre;
	}

	public double getPrecioVenta() {
		return precioVenta;
	}

	public double getCostoProduccion() {
		return costoProduccion;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}

	public void setCostoProduccion(double costoProduccion) {
		this.costoProduccion = costoProduccion;
	}

	@Override
	public String toString() {
		return "Plato [idPlato=" + idPlato +
				", nombre=" + nombre +
				", precioVenta=" + precioVenta + "]";
	}
	
	public boolean equals(Plato plato)
	{
	    return this.nombre.equalsIgnoreCase(plato.getNombre());
	}

}
