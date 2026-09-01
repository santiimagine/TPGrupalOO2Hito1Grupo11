package modelo;
import java.util.Set;
import java.util.HashSet;
import java.time.LocalDate;

public class Festival {
	private int id;
	private String nombre;
	private String temporada;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private Set<UnidadVenta> unidades;

	public Festival() {}

	public Festival(int id, String nombre, String temporada, LocalDate fechaInicio, LocalDate fechaFin) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.temporada = temporada;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.unidades = new HashSet<UnidadVenta>();

	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTemporada() {
		return temporada;
	}
	public void setTemporada(String temporada) {
		this.temporada = temporada;
	}
	public LocalDate getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public LocalDate getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}
	public Set<UnidadVenta> getUnidades() {
		return this.unidades;
	}

	public void setUnidades(Set<UnidadVenta> unidades) {
		this.unidades = unidades;
	}

	@Override
	public String toString() {
		return "\nFestival [id=" + id + ", nombre=" + nombre + ", temporada=" + temporada + ", fechaInicio=" + fechaInicio

				+ ", fechaFin=" + fechaFin + " Unidades=" + unidades + "]";
	
	}
	
	public boolean equals(Festival festival)
	{
		return this.getNombre().equalsIgnoreCase(festival.getNombre()) && 
				this.getFechaInicio().isEqual(festival.fechaInicio) && 
				this.getFechaFin().isEqual(festival.getFechaFin());
	}



	
	
}
