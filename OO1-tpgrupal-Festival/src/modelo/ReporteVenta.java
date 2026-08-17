package modelo;

public class ReporteVenta {

	private UnidadVenta unidad;
	private double totalRecaudado;

	public ReporteVenta(UnidadVenta unidad, double totalRecaudado) {
		this.unidad = unidad;
		this.totalRecaudado = totalRecaudado;
	}

	public UnidadVenta getUnidad() {
		return unidad;
	}

	public double getTotalRecaudado() {
		return totalRecaudado;
	}

	@Override
	public String toString() {
		return "\nReporteVenta [unidad="
				+ unidad.getNombreComercial()
				+ ", totalRecaudado="
				+ totalRecaudado + "]";
	}
}