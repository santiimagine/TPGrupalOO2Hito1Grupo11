package test;

import java.time.LocalDate;
import java.util.List;

import modelo.*;

public class Test {

	/*
	public static void main(String[] args) {
		Sistema s = new Sistema();

		
		// ARMADO DEL SISTEMA
		try {

			// ====================================================
			// EMPLEADOS - CU 1
			// ====================================================

			s.agregarCocinero("Juan", "Perez", "12345678", LocalDate.of(1990, 5, 10), LocalDate.of(2020, 1, 1),
					"Parrilla", 25000);

			s.agregarCajero("Maria", "Gomez", "87654321", LocalDate.of(1995, 3, 15), LocalDate.of(2021, 1, 1),
					Turno.MANIANA);

			s.agregarCajero("Pedro", "Lopez", "33333333", LocalDate.of(1992, 8, 20), LocalDate.of(2022, 1, 1),
					Turno.NOCHE);

			// ====================================================
			// RECUPERO EMPLEADOS
			// ====================================================

			Empleado juan = s.buscarEmpleadoPorDni("12345678");
			Empleado maria = s.buscarEmpleadoPorDni("87654321");
			Empleado pedro = s.buscarEmpleadoPorDni("33333333");

			// ====================================================
			// UNIDADES DE VENTA - CU 1
			// ====================================================

			s.agregarFoodTruck("Truck Burger", juan, 20, "ABC1234567", "AA123BB", true);

			s.agregarPuestoDesarmable("Puesto Pizza", pedro, 20, "XYZ1234567", 2, 30);

			s.agregarFoodTruck("Truck Tacos", maria, 30, "DEF1234567", "BB123CC", false);

			s.agregarPuestoDesarmable("Puesto Helados", juan, 25, "HIJ1234567", 4, 20);
			
			s.agregarFoodTruck("Truck Sushi", pedro, 18, "STR1234567", "CC789DD", true);
			s.agregarPuestoDesarmable("Puesto Crepes", maria, 22, "CRP1234567", 3, 25);
			s.agregarFoodTruck("Truck Asado", juan, 35, "ASA1234567", "DD012EE", false);
			s.agregarPuestoDesarmable("Puesto Vegano", pedro, 20, "VEG1234567", 2, 15);

			// ====================================================
			// RECUPERO UNIDADES
			// ====================================================

			FoodTruck foodtruck = (FoodTruck) s.buscarUnidadPorCodigo("ABC1234567");

			PuestoDesarmable puesto = (PuestoDesarmable) s.buscarUnidadPorCodigo("XYZ1234567");

			FoodTruck truckTacos = (FoodTruck) s.buscarUnidadPorCodigo("DEF1234567");

			PuestoDesarmable puestoHelados = (PuestoDesarmable) s.buscarUnidadPorCodigo("HIJ1234567");
			
			FoodTruck truckSushi = (FoodTruck) s.buscarUnidadPorCodigo("STR1234567");
			PuestoDesarmable puestoCrepes = (PuestoDesarmable) s.buscarUnidadPorCodigo("CRP1234567");
			FoodTruck truckAsado = (FoodTruck) s.buscarUnidadPorCodigo("ASA1234567");
			PuestoDesarmable puestoVegano = (PuestoDesarmable) s.buscarUnidadPorCodigo("VEG1234567");

			// ====================================================
			// PERSONAL DE CADA UNIDAD
			// ====================================================

			foodtruck.agregarEmpleado(juan);
			foodtruck.agregarEmpleado(maria);

			puesto.agregarEmpleado(pedro);

			truckTacos.agregarEmpleado(maria);

			puestoHelados.agregarEmpleado(juan);
			
			truckSushi.agregarEmpleado(pedro);
			truckSushi.agregarEmpleado(maria);
			puestoCrepes.agregarEmpleado(maria);
			truckAsado.agregarEmpleado(juan);
			puestoVegano.agregarEmpleado(pedro);

			// ====================================================
			// AGREGAR PLATOS A LAS UNIDADES
			// ====================================================
			
			foodtruck.agregarPlato("Hamburguesa", 15000, 7000); 
			foodtruck.agregarPlato("Papas Fritas", 8000, 3000); 
			
			puesto.agregarPlato("Tacos", 10000, 4000);
			puesto.agregarPlato("Nachos", 7000, 2500); 
			
			truckTacos.agregarPlato("Pizza", 12000, 5000);
			
			puesto.agregarPlato("Empanadas", 6000, 2000);
			truckTacos.agregarPlato("Burrito", 11000, 4500);
			puestoHelados.agregarPlato("Helado de Chocolate", 5000, 1500);
			puestoHelados.agregarPlato("Helado de Frutilla", 4500, 1500);
			
			truckSushi.agregarPlato("Roll California", 16000, 7000);
			truckSushi.agregarPlato("Sashimi", 20000, 9000);
			puestoCrepes.agregarPlato("Crepe Dulce", 8000, 3000);
			puestoCrepes.agregarPlato("Crepe Salado", 9000, 3500);
			
			truckAsado.agregarPlato("Choripan", 7000, 2500);
			truckAsado.agregarPlato("Asado", 25000, 10000);
			puestoVegano.agregarPlato("Wrap Vegano", 10000, 4000);
			puestoVegano.agregarPlato("Burger Vegana", 12000, 5000);


			// ====================================================
			// FESTIVAL - CU 1
			// ====================================================

			Festival festival = s.agregarFestival("Lollapalooza", "Verano", LocalDate.of(2025, 3, 21),
					LocalDate.of(2025, 3, 23));

			Festival festivalRock = s.agregarFestival("Cosquin Rock", "Invierno", LocalDate.of(2025, 7, 10),
					LocalDate.of(2025, 7, 12));
			
			

			// ====================================================
			// UNIDADES DEL FESTIVAL
			// ====================================================

			festival.getUnidades().add(foodtruck);
			festival.getUnidades().add(puesto);

			festivalRock.getUnidades().add(foodtruck);
			festivalRock.getUnidades().add(truckTacos);
			
			festival.getUnidades().add(truckSushi);
			festival.getUnidades().add(puestoCrepes);

			festivalRock.getUnidades().add(truckAsado);
			festivalRock.getUnidades().add(puestoVegano);

			// ====================================================
			// PEDIDOS
			// ====================================================
			

			// PEDIDO
			Pedido pedido1 = s.agregarPedido(LocalDate.of(2025, 3, 22), foodtruck.getCodigo(), "Lollapalooza", LocalDate.of(2025, 3, 21),LocalDate.of(2025, 3, 23));			
			pedido1.agregarItem(foodtruck.buscarPlato("Hamburguesa"), 2);
			pedido1.agregarItem(foodtruck.buscarPlato("Papas Fritas"), 2);
			
			Pedido pedido2 = s.agregarPedido(LocalDate.of(2025, 3, 21), puesto.getCodigo(), "Lollapalooza", LocalDate.of(2025, 3, 21), LocalDate.of(2025, 3, 23));
			pedido2.agregarItem(puesto.buscarPlato("Empanadas"), 4);
			pedido2.agregarItem(puesto.buscarPlato("Nachos"), 3);

			Pedido pedido3 = s.agregarPedido(LocalDate.of(2025, 3, 23), foodtruck.getCodigo(), "Lollapalooza", LocalDate.of(2025, 3, 21), LocalDate.of(2025, 3, 23));
			pedido3.agregarItem(foodtruck.buscarPlato("Hamburguesa"), 4);
			pedido3.agregarItem(foodtruck.buscarPlato("Papas Fritas"), 2);

			// PEDIDOS COSQUIN ROCK
			Pedido pedido4 = s.agregarPedido(LocalDate.of(2025, 7, 10), foodtruck.getCodigo(), "Cosquin Rock", LocalDate.of(2025, 7, 10), LocalDate.of(2025, 7, 12));
			pedido4.agregarItem(foodtruck.buscarPlato("Hamburguesa"), 5);
			pedido4.agregarItem(foodtruck.buscarPlato("Papas Fritas"), 3);

			Pedido pedido5 = s.agregarPedido(LocalDate.of(2025, 7, 11), truckTacos.getCodigo(), "Cosquin Rock", LocalDate.of(2025, 7, 10), LocalDate.of(2025, 7, 12));
			pedido5.agregarItem(truckTacos.buscarPlato("Burrito"), 6);
			pedido5.agregarItem(truckTacos.buscarPlato("Pizza"), 3);

			Pedido pedido6 = s.agregarPedido(LocalDate.of(2025, 7, 12), foodtruck.getCodigo(), "Cosquin Rock", LocalDate.of(2025, 7, 10), LocalDate.of(2025, 7, 12));
			pedido6.agregarItem(foodtruck.buscarPlato("Hamburguesa"), 2);
			
			Pedido pedido7 = s.agregarPedido(LocalDate.of(2025, 3, 21), truckSushi.getCodigo(), "Lollapalooza", LocalDate.of(2025, 3, 21), LocalDate.of(2025, 3, 23));
			pedido7.agregarItem(truckSushi.buscarPlato("Roll California"), 3);
			pedido7.agregarItem(truckSushi.buscarPlato("Sashimi"), 2);

			Pedido pedido8 = s.agregarPedido(LocalDate.of(2025, 3, 22), puestoCrepes.getCodigo(), "Lollapalooza", LocalDate.of(2025, 3, 21), LocalDate.of(2025, 3, 23));
			pedido8.agregarItem(puestoCrepes.buscarPlato("Crepe Dulce"), 4);
			pedido8.agregarItem(puestoCrepes.buscarPlato("Crepe Salado"), 2);

			Pedido pedido9 = s.agregarPedido(LocalDate.of(2025, 3, 23), truckSushi.getCodigo(), "Lollapalooza", LocalDate.of(2025, 3, 21), LocalDate.of(2025, 3, 23));
			pedido9.agregarItem(truckSushi.buscarPlato("Roll California"), 5);

			// PEDIDOS COSQUIN ROCK
			Pedido pedido10 = s.agregarPedido(LocalDate.of(2025, 7, 10), truckAsado.getCodigo(), "Cosquin Rock", LocalDate.of(2025, 7, 10), LocalDate.of(2025, 7, 12));
			pedido10.agregarItem(truckAsado.buscarPlato("Choripan"), 6);
			pedido10.agregarItem(truckAsado.buscarPlato("Asado"), 3);

			Pedido pedido11 = s.agregarPedido(LocalDate.of(2025, 7, 11), puestoVegano.getCodigo(), "Cosquin Rock", LocalDate.of(2025, 7, 10), LocalDate.of(2025, 7, 12));
			pedido11.agregarItem(puestoVegano.buscarPlato("Wrap Vegano"), 4);
			pedido11.agregarItem(puestoVegano.buscarPlato("Burger Vegana"), 3);

			Pedido pedido12 = s.agregarPedido(LocalDate.of(2025, 7, 12), truckAsado.getCodigo(), "Cosquin Rock", LocalDate.of(2025, 7, 10), LocalDate.of(2025, 7, 12));
			pedido12.agregarItem(truckAsado.buscarPlato("Asado"), 5);
			pedido12.agregarItem(truckAsado.buscarPlato("Choripan"), 2);
			

		} catch (Exception e) {

			System.out.println(e.getMessage());

		}

		try {

			System.out.println("\n========== CU1 ERROR EMPLEADO REPETIDO ==========");

			s.agregarCocinero("Pedro", "Lopez", "12345678", LocalDate.of(1980, 1, 1), LocalDate.of(2020, 1, 1),
					"Pastas", 10000);

		} catch (Exception e) {

			System.out.println(e.getMessage());

		}

		try {

			System.out.println("\n========== CU1 ERROR MENOR DE EDAD ==========");

			s.agregarCajero("Luis", "Diaz", "99999999", LocalDate.now().minusYears(15), LocalDate.now(), Turno.NOCHE);

		} catch (Exception e) {

			System.out.println(e.getMessage());

		}

		try {

			System.out.println("\n========== CU2 BUSQUEDAS ==========");

			Empleado e = s.buscarEmpleadoPorDni("12345678");

			System.out.println("Empleado encontrado: ");
			System.out.println(e);

		} catch (Exception e) {

			System.out.println(e.getMessage());

		}

		// NO TIENE EXCEPTION
		System.out.println("\n========== CU2 NO ENCONTRADO ==========");

		Empleado emp = s.buscarEmpleadoPorDni("00000000");

		if (emp == null) {

			System.out.println("Empleado inexistente");

		}
		;

		try {

			System.out.println("\n========== CU3 CANON ==========");

			UnidadVenta ft = s.buscarUnidadPorCodigo("ABC1234567");

			System.out.println("Calculo de canon de: " + ft);
			System.out.println(ft.calcularCanon());

		} catch (Exception e) {

			System.out.println(e.getMessage());

		}

		try {

			System.out.println("\n===== CU4 SUELDO =====");

			Empleado e = s.buscarEmpleadoPorDni("12345678");

			System.out.println("Calculo de sueldo de:" + e);
			System.out.println(e.calcularSueldo());

		} catch (Exception e) {

			System.out.println(e.getMessage());

		}

		try {

			System.out.println("\n===== CU5 ERROR FECHA =====");
			
			s.agregarPedido(LocalDate.of(2025, 5, 10), "ABC1234567", "Lollapalooza", LocalDate.of(2025, 3, 21), LocalDate.of(2025, 3, 23));			


		} catch (Exception e) {

			System.out.println(e.getMessage());

		}

		try {

			System.out.println("\n===== CU6 RECAUDACION =====");

			Festival festival = s.buscarFestival("Lollapalooza", LocalDate.of(2025, 3, 21), LocalDate.of(2025, 3, 23));

			List<ReporteVenta> lista = s.reporteRecaudacion(festival);

			for (ReporteVenta r : lista) {
				System.out.println(r);
			}

		} catch (Exception e) {

			System.out.println(e.getMessage());

		}

		try {

			System.out.println("\n===== CU7 FILTRO =====");

			List<Empleado> lista = s.filtrarEmpleadosPorEdad(LocalDate.of(1980, 1, 1), LocalDate.of(1993, 1, 1));

			for (Empleado e : lista) {
				System.out.println(e);
			}

		} catch (Exception e) {

			System.out.println(e.getMessage());

		}

		try {

			System.out.println("\n===== CU8 RENTABILIDAD =====");

			FoodTruck foodtruck = (FoodTruck) s.buscarUnidadPorCodigo("ABC1234567");

			System.out.println(foodtruck.calcularRentabilidadNeta());

			System.out.println("\n===== CU9 RENTABILIDAD ENTRE FECHAS =====");

			System.out.println(foodtruck.calcularRentabilidadNetaEntreFechas(LocalDate.of(2025, 3, 21),
					LocalDate.of(2025, 3, 23)));

		} catch (Exception e) {

			System.out.println(e.getMessage());

		}

		try {

			System.out.println("\n===== CU10 RANKING =====");

			Festival festival = s.buscarFestival("Lollapalooza", LocalDate.of(2025, 3, 21), LocalDate.of(2025, 3, 23));

			List<UnidadVenta> ranking = s.rankingUnidades(festival);

			for (UnidadVenta u : ranking) {
				System.out.println(u.getNombreComercial());
			}

		} catch (Exception e) {

			System.out.println(e.getMessage());

		}

		try {

			System.out.println("\n===== CU11 PLATO ESTRELLA =====");

			FoodTruck foodtruck = (FoodTruck) s.buscarUnidadPorCodigo("ABC1234567");
			Festival festival = s.buscarFestival("Lollapalooza", LocalDate.of(2025, 3, 21), LocalDate.of(2025, 3, 23));

			System.out.println(foodtruck.platoEstrella(festival));

		} catch (Exception e) {

			System.out.println(e.getMessage());

		}

		try {

			System.out.println("\n===== CU12 AUDITORIA =====");

			Festival festival = s.buscarFestival("Lollapalooza", LocalDate.of(2025, 3, 21), LocalDate.of(2025, 3, 23));

			List<Empleado> lista = s.auditoriaPersonal(festival);

			for (Empleado e : lista) {
				System.out.println(e);
			}

		} catch (Exception e) {

			System.out.println(e.getMessage());

		}

		try {

			System.out.println("\n===== CU13 TOP 3 =====");

			Festival festival = s.buscarFestival("Lollapalooza", LocalDate.of(2025, 3, 21), LocalDate.of(2025, 3, 23));

			List<ReporteMayoresCanon> lista = s.top3UnidadesMayorCanon(festival);

			for (ReporteMayoresCanon r : lista) {
				System.out.println(r);
			}

		} catch (Exception e) {

			System.out.println(e.getMessage());

		}

	}
	*/
	
}