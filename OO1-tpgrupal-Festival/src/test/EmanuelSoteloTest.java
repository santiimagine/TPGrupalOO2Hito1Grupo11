package test;

import java.util.List;

import modelo.ItemPedido;
import modelo.Pedido;
import negocio.ItemPedidoAbm;
import negocio.PedidoAbm;

public class EmanuelSoteloTest {

	public static void main(String[] args) {

		//Query 1
		String nombrePlato = "Hamburguesa Clásica";

		Long total = ItemPedidoAbm.getInstance().cantidadVendidaDePlato(nombrePlato);

		System.out.println("\n===== CANTIDAD VENDIDA =====");
		System.out.println("Plato: " + nombrePlato);
		System.out.println("Cantidad total vendida: " + (total != null ? total : 0));

		//Query 2
		int idFestival = 1;

		List<Pedido> pedidos = PedidoAbm.getInstance().traerPedidosDeFestival(idFestival);

		for (Pedido p : pedidos) {

			System.out.println("\n===== PEDIDO =====");
			System.out.println("Fecha: " + p.getFecha());
			System.out.println("Unidad de venta: " + p.getUnidadVenta().getNombreComercial());

			for (ItemPedido item : p.getItems()) {
				System.out.println("-Plato: " + item.getPlato().getNombre() + " x" + item.getCantidad());
			}
		}
	}
}