package modelo;

public class ReporteMayoresCanon {
	private String nombreComercial;
	private String codigo;
	private String tipoUnidad;
	private double cannon;
	
	public ReporteMayoresCanon(String nombreComercial, String codigo, String tipoUnidad, double cannon) {
		super();
		this.nombreComercial = nombreComercial;
		this.codigo = codigo;
		this.tipoUnidad = tipoUnidad;
		this.cannon = cannon;
	}

	
	
	
	public String getNombreComercial() {
		return nombreComercial;
	}
	public void setNombreComercial(String nombreComercial) {
		this.nombreComercial = nombreComercial;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getTipoUnidad() {
		return tipoUnidad;
	}
	public void setTipoUnidad(String tipoUnidad) {
		this.tipoUnidad = tipoUnidad;
	}
	public double getCannon() {
		return cannon;
	}
	public void setCannon(double cannon) {
		this.cannon = cannon;
	}











	@Override
	public String toString() {
		return "\nReporteMayorCanon"
				+ " [nombreComercial=" + nombreComercial
				+ ", codigo=" + codigo 
				+ ", tipoUnidad="+ tipoUnidad
				+ ", cannon=" + cannon + "]";
	}
	
}
