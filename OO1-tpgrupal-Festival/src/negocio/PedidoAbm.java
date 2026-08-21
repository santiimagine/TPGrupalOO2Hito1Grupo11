package negocio;

import java.time.LocalDate;
import java.util.List;

import dao.PedidoDao;
import modelo.Festival;
import modelo.Pedido;
import modelo.UnidadVenta;

public class PedidoAbm {

	private static PedidoAbm instancia = null;

	protected PedidoAbm() {}

	public static PedidoAbm getInstance() {
		if (instancia == null)
			instancia = new PedidoAbm();
		return instancia;
	}

	public Pedido traer(int idPedido) {
		return PedidoDao.getInstance().traer(idPedido);
	}

	public List<Pedido> traer() {
		return PedidoDao.getInstance().traer();
	}

	public int agregar(LocalDate fecha, Festival festival, UnidadVenta unidadVenta) throws Exception {
		// Pendiente implementar lógica de negocio
		Pedido p = new Pedido(fecha, festival, unidadVenta);
		return PedidoDao.getInstance().agregar(p);
	}

	public void modificar(Pedido p) {
		// Pendiente implementar lógica de negocio
		PedidoDao.getInstance().actualizar(p);
	}

	public void eliminar(Pedido p) {
		// Pendiente implementar lógica de negocio
		PedidoDao.getInstance().eliminar(p);
	}

}
