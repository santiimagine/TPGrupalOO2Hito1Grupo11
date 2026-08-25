package negocio;

import java.time.LocalDate;
import java.util.List;

import dao.FestivalDao;
import modelo.Festival;

public class FestivalAbm {

	private static FestivalAbm instancia = null;

	protected FestivalAbm() {}

	public static FestivalAbm getInstance() {
		if (instancia == null)
			instancia = new FestivalAbm();
		return instancia;
	}

	public Festival traer(int idFestival) {
		return FestivalDao.getInstance().traer(idFestival);
	}

	public List<Festival> traer() {
		return FestivalDao.getInstance().traer();
	}

	public int agregar(String nombre, String temporada, LocalDate fechaInicio, LocalDate fechaFin) {
		// Pendiente implementar lógica de negocio (ej. validar que no se solape con otro festival)
		Festival f = new Festival();
		f.setNombre(nombre);
		f.setTemporada(temporada);
		f.setFechaInicio(fechaInicio);
		f.setFechaFin(fechaFin);
		return FestivalDao.getInstance().agregar(f);
	}

	public void modificar(Festival f) {
		// Pendiente implementar lógica de negocio
		FestivalDao.getInstance().actualizar(f);
	}

	public void eliminar(Festival f) {
		// Pendiente implementar lógica de negocio
		FestivalDao.getInstance().eliminar(f);
	}

}
