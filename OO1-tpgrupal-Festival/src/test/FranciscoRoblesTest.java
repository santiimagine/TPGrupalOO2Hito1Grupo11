package test;

import java.util.List;

import modelo.Empleado;
import modelo.Plato;
import negocio.ItemPedidoAbm;
import negocio.UnidadVentaAbm;

public class FranciscoRoblesTest {

	public static void main(String[] args) {
		
		UnidadVentaAbm unidadVentaAbm = UnidadVentaAbm.getInstance();
		
		/* CASO DE USO FR1 - TRAER PERSONAL COMPLETO DE UNA UNIDAD DE VENTA ESPECÍFICA*/
		int idUnidadVentaAConsultar = 1;
		List<Empleado> personal = unidadVentaAbm.traerPersonalCompleto(idUnidadVentaAConsultar);
		
		System.out.println("\n============ PERSONAL COMPLETO DE LA UNIDAD DE VENTA ID = " + idUnidadVentaAConsultar + " ============\n");
		for (Empleado e: personal) {
			System.out.println(e);
		}
		
		System.out.println("\n\n");
		
		/* CASO DE USO FR2 - TRAER EL PLATO MÁS PEDIDO DE UN FESTIVAL EN ESPECIFICO */
		ItemPedidoAbm itemPedidoAbm = ItemPedidoAbm.getInstance();
		
		int idFestivalAConsultar = 1;
		
		Object[] resultado = itemPedidoAbm.traerPlatoMasPedido(idFestivalAConsultar);

		if (resultado != null) {
		    Plato plato = (Plato) resultado[0];
		    Long cantidad = (Long) resultado[1];
		    System.out.println("\n============ PLATO MAS PEDIDO DEL FESTIVAL " + idFestivalAConsultar + ": " + plato.getNombre() + " (" + cantidad + " unidades) ============\n");
		} else {
		    System.out.println(" ============ EL FESTIVAL NO TIENE PEDIDOS. ============");
		}

	}

}
