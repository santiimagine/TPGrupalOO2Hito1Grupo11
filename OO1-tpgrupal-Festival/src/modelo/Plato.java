package modelo;

public class Plato {
	private int id;
	private String nombre;
	private double precioVenta;
	private double costoProduccion;

	//CONSTRUCTOR
	public Plato(int id, String nombre, double precioVenta, double costoProduccion) {
		this.id = id;
		this.nombre = nombre;
		this.precioVenta = precioVenta;
		this.costoProduccion = costoProduccion;
	}

	//GETTERS Y SETTERS 
	public int getId() {
		return id;
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
		return "Plato [id=" + id +
				", nombre=" + nombre +
				", precioVenta=" + precioVenta + "]";
	}
	
	public boolean equals(Plato plato)
	{
	    return this.nombre.equalsIgnoreCase(plato.getNombre());
	}




}
