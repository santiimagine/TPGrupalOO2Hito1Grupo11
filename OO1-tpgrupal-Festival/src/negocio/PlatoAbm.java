package negocio;

import java.util.List;

import dao.PlatoDao;
import modelo.Plato;

public class PlatoAbm {

	private static PlatoAbm instancia = null;

	protected PlatoAbm() {}

	public static PlatoAbm getInstance() {
		if (instancia == null)
			instancia = new PlatoAbm();
		return instancia;
	}

	public Plato traer(int idPlato) {
		return PlatoDao.getInstance().traer(idPlato);
	}

	public List<Plato> traer() {
		return PlatoDao.getInstance().traer();
	}

	public int agregar(String nombre, double precioVenta, double costoProduccion) {
		// Pendiente implementar lógica de negocio (ej. validar que no exista un plato con el mismo nombre)
		Plato p = new Plato(nombre, precioVenta, costoProduccion);
		return PlatoDao.getInstance().agregar(p);
	}

	public void modificar(Plato p) {
		// Pendiente implementar lógica de negocio
		PlatoDao.getInstance().actualizar(p);
	}

	public void eliminar(Plato p) {
		// Pendiente implementar lógica de negocio
		PlatoDao.getInstance().eliminar(p);
	}

}
