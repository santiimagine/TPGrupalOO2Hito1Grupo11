package negocio;

import java.util.List;

import dao.EmpleadoDao;
import modelo.Empleado;

public class EmpleadoAbm {
	
	private static EmpleadoAbm instancia = null;
	
	protected EmpleadoAbm() {}
	
	public static EmpleadoAbm getInstance() {
		if (instancia == null)
			instancia = new EmpleadoAbm();
		return instancia;
	}
	
	public Empleado traer(int idEmpleado) {
		return EmpleadoDao.getInstance().traer(idEmpleado);
	}
	
	public List<Empleado> traer(){
		return EmpleadoDao.getInstance().traer();
	}

}
