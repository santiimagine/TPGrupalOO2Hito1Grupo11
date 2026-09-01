package test;

import modelo.Festival;
import modelo.FoodTruck;
import modelo.PuestoDesarmable;
import modelo.UnidadVenta;
import negocio.FestivalAbm;

public class TestTraerFestivalConUnidades {

	public static void main(String[] args) {

		int idFestival = 1;

		Festival festival = FestivalAbm.getInstance().traerUnidadesVenta(idFestival);

		System.out.println("\n\n===== FESTIVAL =====");
		System.out.println("Nombre: " + festival.getNombre());
		System.out.println("Temporada: " + festival.getTemporada());
		System.out.println("Fecha inicio: " + festival.getFechaInicio());
		System.out.println("Fecha fin: " + festival.getFechaFin());

		System.out.println("\n===== UNIDADES DE VENTA HABILITADAS =====");

		for (UnidadVenta unidad : festival.getUnidades()) {

			System.out.println("Nombre comercial: " + unidad.getNombreComercial());
			System.out.println("Superficie: " + unidad.getSuperficie());
			System.out.println("Codigo: " + unidad.getCodigo());

			if (unidad instanceof FoodTruck) {
				FoodTruck foodTruck = (FoodTruck) unidad;
				System.out.println("Tipo: FoodTruck");
				System.out.println("-Patente: " + foodTruck.getPatente());
				System.out.println("-Requiere electricidad: " + foodTruck.isRequiereElectricidad() + "\n");
			} else if (unidad instanceof PuestoDesarmable) {
				PuestoDesarmable puesto = (PuestoDesarmable) unidad;
				System.out.println("Tipo: PuestoDesarmable");
				System.out.println("-Cantidad carpas: " + puesto.getCantidadCarpas());
				System.out.println("-Tiempo montaje: " + puesto.getTiempoMontaje() +  "\n");
			}
		}

	}

}
