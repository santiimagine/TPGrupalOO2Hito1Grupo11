package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import modelo.Festival;

public class Sistema {

	List<Festival> lstFestivales;
	List<Empleado> lstEmpleados;
	List<UnidadVenta> lstUnidadVenta;

	public Sistema() {
		super();
		this.lstFestivales = new ArrayList<Festival>();
		this.lstEmpleados = new ArrayList<Empleado>();
		this.lstUnidadVenta = new ArrayList<UnidadVenta>();
	}

	public List<Festival> getLstFestivales() {
		return lstFestivales;
	}

	public List<Empleado> getLstEmpleados() {
		return lstEmpleados;
	}

	public List<UnidadVenta> getLstUnidadVenta() {
		return lstUnidadVenta;
	}

	// FESTIVAL
	// FESTIVAL
	public Festival agregarFestival(String nombre, String temporada, LocalDate fechaInicio, LocalDate fechaFin)
			throws Exception {
		if (festivalSolapaFecha(nombre, fechaInicio, fechaFin)) {
			throw new Exception("Error: no se puede agregar un festival que ya se está festejando");
		}

		int id = lstFestivales.isEmpty() ? 1 : lstFestivales.get(lstFestivales.size() - 1).getId() + 1;
		Festival nuevo = new Festival(id, nombre, temporada, fechaInicio, fechaFin);
		lstFestivales.add(nuevo);
		return nuevo;
	}

	// CASO DE USO N°5: Registro de pedido validado: Método para agregar un pedido
	// que invoque
	// internamente al CU #2 para validar la existencia de la Unidad y el Festival.
	// PIDE FECHA INICIO Y FECHA FIN DE FESTIVAL
	public Pedido agregarPedido(LocalDate fecha, String codigoUnidad, String nombreFestival, LocalDate fechaInicioFestival, LocalDate fechaFinFestival) throws Exception {

		// CU2
		UnidadVenta unidadEncontrada = buscarUnidadPorCodigo(codigoUnidad);

		Festival festivalEncontrado = buscarFestival(nombreFestival, fechaInicioFestival, fechaFinFestival);

		if (unidadEncontrada == null) {
			throw new Exception("La unidad de venta no existe");
		} else if (festivalEncontrado == null) {
			throw new Exception("El festival no existe");
		}

		int id;

		if (unidadEncontrada.getPedidos().isEmpty()) {
			id = 1;
		} else {
			id = unidadEncontrada.getPedidos().get(unidadEncontrada.getPedidos().size() - 1).getId() + 1;
		}

		Pedido nuevo = new Pedido(id, fecha, festivalEncontrado);

		unidadEncontrada.getPedidos().add(nuevo);

		return nuevo;
	}
	
	

	public boolean eliminarFestival(int id) {
		boolean eliminado = false;

		int i = 0;

		while (i < lstFestivales.size() && !eliminado) {
			if (lstFestivales.get(i).getId() == id) {
				lstFestivales.remove(i);
				eliminado = true;
			}

			i++;
		}

		return eliminado;
	}

	public Festival buscarFestival(String nombre, LocalDate fechaInicio, LocalDate fechaFin) {
		Festival f = null;
		Festival buscado = new Festival(0, nombre, null, fechaInicio, fechaFin);
		int i = 0;
		while (i < lstFestivales.size() && f == null) {
			if (this.lstFestivales.get(i).equals(buscado)) {
				f = lstFestivales.get(i);
			}
			i++;
		}

		return f;
	}

	// Método que verifica que un festival no se solape en fechas con otros
	// (Festivales de mismo nombre únicamente)
	private boolean festivalSolapaFecha(String nombre, LocalDate fechaInicio, LocalDate fechaFin) {
		boolean solapa = false;
		for (Festival f : this.getLstFestivales()) {
			if (f.getNombre().equalsIgnoreCase(nombre)) {
				if (!fechaFin.isBefore(f.getFechaInicio()) && !fechaInicio.isAfter(f.getFechaFin())) {
					solapa = true;
				}
			}
		}
		return solapa;
	}

	// UNIDAD
	public boolean agregarFoodTruck(String nombreComercial, Empleado responsable, double superficie, String codigo,
			String patente, boolean requiereElectricidad) throws Exception {

		boolean agregado = false;

		if (buscarUnidadPorCodigo(codigo) != null) {
			throw new Exception("Ya existe una unidad con ese código");
		}

		int id;

		if (lstUnidadVenta.isEmpty()) {
			id = 1;
		} else {
			id = lstUnidadVenta.get(lstUnidadVenta.size() - 1).getId() + 1;
		}

		FoodTruck nuevo = new FoodTruck(id, nombreComercial, responsable, superficie, codigo, patente,
				requiereElectricidad);

		agregado = lstUnidadVenta.add(nuevo);

		return agregado;
	}

	public boolean agregarPuestoDesarmable(String nombreComercial, Empleado responsable, double superficie,
			String codigo, int cantidadCarpas, int tiempoMontaje) throws Exception {

		boolean agregado = false;

		if (buscarUnidadPorCodigo(codigo) != null) {
			throw new Exception("Ya existe una unidad con ese código");
		}

		int id;

		if (lstUnidadVenta.isEmpty()) {
			id = 1;
		} else {
			id = lstUnidadVenta.get(lstUnidadVenta.size() - 1).getId() + 1;
		}

		PuestoDesarmable nuevo = new PuestoDesarmable(id, nombreComercial, responsable, superficie, codigo,
				cantidadCarpas, tiempoMontaje);

		agregado = lstUnidadVenta.add(nuevo);

		return agregado;
	}

	public boolean eliminarUnidadVenta(String codigo) throws Exception {
		boolean eliminado = false;
		int i = 0;
		while (i < lstUnidadVenta.size() && eliminado == false) {
			if (lstUnidadVenta.get(i).getCodigo().equals(codigo)) {
				lstUnidadVenta.remove(i);
				eliminado = true;
			}
			i++;
		}

		if (eliminado == false) {
			throw new Exception("La Unidad-Venta ingresada no existe");
		}
		return eliminado;
	}

	public UnidadVenta buscarUnidadPorCodigo(String codigo) {
		UnidadVenta uv = null;
		int i = 0;
		while (i < lstUnidadVenta.size() && uv == null) {

			if (lstUnidadVenta.get(i).getCodigo().equals(codigo)) {
				uv = lstUnidadVenta.get(i);
			}
			i++;
		}

		return uv;
	}

	// EMPLEADO
	public boolean agregarCajero(String nombre, String apellido, String dni, LocalDate fechaNacimiento,
			LocalDate fechaIngreso, Turno turno) throws Exception {
		
		boolean agregado = false;

		if (buscarEmpleadoPorDni(dni) != null) {
			throw new Exception("El empleado ya existe");
		}

		int id;

		if (lstEmpleados.isEmpty()) {
			id = 1;
		} else {
			id = lstEmpleados.get(lstEmpleados.size() - 1).getId() + 1;
		}

		Cajero nuevo = new Cajero(id, nombre, apellido, dni, fechaNacimiento, fechaIngreso, turno);

		agregado = lstEmpleados.add(nuevo);

		return agregado;
	}

	public boolean agregarCocinero(String nombre, String apellido, String dni, LocalDate fechaNacimiento,
			LocalDate fechaIngreso, String especialidad, double plusCategoria) throws Exception {

		boolean agregado = false;

		if (buscarEmpleadoPorDni(dni) != null) {
			throw new Exception("El empleado ya existe");
		}

		int id;

		if (lstEmpleados.isEmpty()) {
			id = 1;
		} else {
			id = lstEmpleados.get(lstEmpleados.size() - 1).getId() + 1;
		}

		Cocinero nuevo = new Cocinero(id, nombre, apellido, dni, fechaNacimiento, fechaIngreso, especialidad,
				plusCategoria);
		agregado = lstEmpleados.add(nuevo);

		return agregado;
	}

	public boolean eliminarEmpleado(String dni) throws Exception {
		boolean eliminado = false;
		int i = 0;
		while (i < lstEmpleados.size() && eliminado == false) {
			if (lstEmpleados.get(i).getDni().equals(dni)) {
				lstEmpleados.remove(i);
				eliminado = true;
			}
			i++;
		}
		if (eliminado == false) {
			throw new Exception("El empleado a eliminar no existe");
		}
		return eliminado;
	}

	public Empleado buscarEmpleadoPorDni(String dni) {
		Empleado e = null;
		int i = 0;
		while (i < lstEmpleados.size() && e == null) {

			if (lstEmpleados.get(i).getDni().equalsIgnoreCase(dni)) {
				e = lstEmpleados.get(i);
			}
			i++;
		}

		return e;
	}


	
	

	// CASO DE USO N°6
	public List<ReporteVenta> reporteRecaudacion(Festival festival) {
		List<ReporteVenta> reporte = new ArrayList<>();

		for (UnidadVenta unidad : lstUnidadVenta) {
			double recaudacion = unidad.calcularRecaudacion(festival);

			if (recaudacion > 0) {
				reporte.add(new ReporteVenta(unidad, recaudacion));
			}
		}

		return reporte;
	}

	// CASO DE USO N°7
	public List<Empleado> filtrarEmpleadosPorEdad(LocalDate desde,LocalDate hasta)
	{
		List<Empleado> empleadosEncontrados = new ArrayList<Empleado>();
		int i=0;
		while(i<lstEmpleados.size())
		{
			if(
					(!lstEmpleados.get(i).getFechaNacimiento().isBefore(desde))
					&& 
					(!lstEmpleados.get(i).getFechaNacimiento().isAfter(hasta))
					)
			{
				empleadosEncontrados.add(lstEmpleados.get(i));
			}
			i++;
		}
		return empleadosEncontrados;
	}

	// CU 10 - RANKING UNIDADES DE MAYOR A MENOS
	public List<UnidadVenta> rankingUnidades(Festival festival) {
		List<UnidadVenta> lstRankingUnidades = new ArrayList<UnidadVenta>();

		lstRankingUnidades.addAll(festival.getUnidades());

		int i = 0;

		while (i < lstRankingUnidades.size()) {
			int j = i + 1;

			while (j < lstRankingUnidades.size()) {
				if (lstRankingUnidades.get(i).calcularRecaudacion(festival) < lstRankingUnidades.get(j)
						.calcularRecaudacion(festival)) {
					UnidadVenta aux = lstRankingUnidades.get(i);

					lstRankingUnidades.set(i, lstRankingUnidades.get(j));

					lstRankingUnidades.set(j, aux);
				}

				j++;
			}

			i++;
		}

		return lstRankingUnidades;
	}

	// FX PARA QUE NO SE REPITA EL EMPLEADO EN LA LISTA
	private boolean existeEmpleado(List<Empleado> lista, Empleado empleado) {
		boolean existe = false;

		int i = 0;

		while (i < lista.size() && !existe) {
			if (lista.get(i).equals(empleado)) {
				existe = true;
			}

			i++;
		}

		return existe;
	}

	// CU12 - AUDITORIA PERSONAL DEL FESTIVAL
	public List<Empleado> auditoriaPersonal(Festival festival) {
		List<Empleado> empleadosEncontrados = new ArrayList<>();

		for (UnidadVenta unidad : festival.getUnidades()) {
			for (Empleado empleado : unidad.getPersonal()) {
				if (!existeEmpleado(empleadosEncontrados, empleado)) {
					empleadosEncontrados.add(empleado);
				}
			}
		}

		return empleadosEncontrados;
	}

	// CASO DE USO N°13

	public List<ReporteMayoresCanon> top3UnidadesMayorCanon(Festival festival) {
		List<ReporteMayoresCanon> reporte = new ArrayList<ReporteMayoresCanon>();

		for (UnidadVenta unidad : festival.getUnidades()) {
			String tipoUnidad;

			if (unidad instanceof FoodTruck) {
				tipoUnidad = "FoodTruck";
			} else {
				tipoUnidad = "PuestoDesarmable";
			}

			ReporteMayoresCanon r = new ReporteMayoresCanon(unidad.getNombreComercial(), unidad.getCodigo(), tipoUnidad,
					unidad.calcularCanon());

			reporte.add(r);
		}

		int i = 0;

		while (i < reporte.size()) {
			int j = i + 1;

			while (j < reporte.size()) {
				if (reporte.get(i).getCannon() < reporte.get(j).getCannon()) {
					ReporteMayoresCanon aux = reporte.get(i);

					reporte.set(i, reporte.get(j));

					reporte.set(j, aux);
				}

				j++;
			}

			i++;
		}

		List<ReporteMayoresCanon> top3 = new ArrayList<ReporteMayoresCanon>();

		i = 0;

		while (i < reporte.size() && i < 3) {
			top3.add(reporte.get(i));

			i++;
		}

		return top3;
	}
}
