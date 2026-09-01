package test;

import modelo.FoodTruck;
import modelo.Plato;
import modelo.PuestoDesarmable;
import modelo.UnidadVenta;
import negocio.UnidadVentaAbm;

public class TestTraerUnidadVentaConPlatos {

	public static void main(String[] args) {

		int idUnidadVenta = 2;

		UnidadVenta unidad = UnidadVentaAbm.getInstance().traerConPlatos(idUnidadVenta);

		System.out.println("\n\nUnidad de venta: " + unidad.getNombreComercial() + " | Codigo: " + unidad.getCodigo() );

		if (unidad instanceof FoodTruck) {
			FoodTruck foodTruck = (FoodTruck) unidad;
			System.out.println("Tipo: FoodTruck | Patente: " + foodTruck.getPatente()
					+ " | Requiere electricidad: " + foodTruck.isRequiereElectricidad());
		} else if (unidad instanceof PuestoDesarmable) {
			PuestoDesarmable puesto = (PuestoDesarmable) unidad;
			System.out.println("Tipo: PuestoDesarmable | Cantidad carpas: " + puesto.getCantidadCarpas()
					+ " | Tiempo montaje: " + puesto.getTiempoMontaje());
		}

		System.out.println("Menu de platos:");

		for (Plato plato : unidad.getPlatos()) {
			System.out.println("  - " + plato.getNombre() + " ($" + plato.getPrecioVenta() + ")");
		}

	}

}
