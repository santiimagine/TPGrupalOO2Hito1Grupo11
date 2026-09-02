package negocio;

import java.util.ArrayList;
import java.util.List;
import dao.UnidadVentaDao;
import modelo.Empleado;
import modelo.UnidadVenta;

public class UnidadVentaAbm {
	
	private static UnidadVentaAbm instancia = null;
	
	protected UnidadVentaAbm() {}
	
	public static UnidadVentaAbm getInstance() {
		if (instancia == null)
			instancia = new UnidadVentaAbm();
		return instancia;
	}
	
	public UnidadVenta traer(int idUnidadVenta) {
		return UnidadVentaDao.getInstance().traer(idUnidadVenta);
	}
	
	public List<UnidadVenta> traer(){
		return UnidadVentaDao.getInstance().traer();
	}

	public UnidadVenta traerConPlatos(int idUnidadVenta) {
		return UnidadVentaDao.getInstance().traerConPlatos(idUnidadVenta);
	}
	
	public List<Empleado> traerPersonalCompleto(int idUnidadVenta){
		UnidadVentaDao dao = UnidadVentaDao.getInstance();
		List<Empleado> listaEmpleados = new ArrayList<>();
		
		Empleado responsable = dao.traerResponsable(idUnidadVenta);
		if (responsable != null) {
			listaEmpleados.add(responsable);
		}
		listaEmpleados.addAll(dao.traerPersonal(idUnidadVenta));
		
		return listaEmpleados;
	}

	

	
	
	
	
	
}
