package negocio;

import java.util.List;

import dao.ItemPedidoDao;
import modelo.ItemPedido;
import modelo.Plato;

public class ItemPedidoAbm {

	private static ItemPedidoAbm instancia = null;

	protected ItemPedidoAbm() {}

	public static ItemPedidoAbm getInstance() {
		if (instancia == null)
			instancia = new ItemPedidoAbm();
		return instancia;
	}

	public ItemPedido traer(int idItemPedido) {
		return ItemPedidoDao.getInstance().traer(idItemPedido);
	}

	public List<ItemPedido> traer() {
		return ItemPedidoDao.getInstance().traer();
	}

	public int agregar(int cantidad, Plato plato) {
		// Pendiente implementar lógica de negocio
		ItemPedido item = new ItemPedido(cantidad, plato);
		return ItemPedidoDao.getInstance().agregar(item);
	}

	public void modificar(ItemPedido item) {
		// Pendiente implementar lógica de negocio
		ItemPedidoDao.getInstance().actualizar(item);
	}

	public void eliminar(ItemPedido item) {
		// Pendiente implementar lógica de negocio
		ItemPedidoDao.getInstance().eliminar(item);
	}
	
	public Object[] traerPlatoMasPedido (int idFestival) {
		return ItemPedidoDao.getInstance().traerPlatoMasPedido(idFestival);
	}

}
