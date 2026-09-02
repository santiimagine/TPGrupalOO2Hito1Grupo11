package test;

import java.util.List;

import modelo.Cocinero;
import modelo.Empleado;
import modelo.Festival;
import negocio.EmpleadoAbm;
import negocio.FestivalAbm;

public class SantiagoSaitzTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Query 1
		 String especialidad = "Heladería";

		 List<Cocinero> cocinerosEspecialidad = EmpleadoAbm.getInstance().traerCocineroPorEspecialidad(especialidad);

		 System.out.println("\nCocineros con especialidad: " + especialidad);

		 for (Cocinero c : cocinerosEspecialidad)
		  {
		     // atributos heredados de Empleado
		     System.out.println("ID: " + c.getId() +
		          " | Nombre: " + c.getNombre() +
		          " | Apellido: " + c.getApellido() +
		          " | DNI: " + c.getDni());      
		  }
		 
		//Query 2
		 
		 System.out.println("\nBúsqueda > PlusCategoria: ");

		 List<Cocinero> cocinerosPlusCategoria = EmpleadoAbm.getInstance().traerCocineroPorPlus();

		 
		 for (Cocinero c : cocinerosPlusCategoria)
		  {
		     System.out.println("ID: " + c.getId() +
		          " | Nombre: " + c.getNombre() +
		          " | Apellido: " + c.getApellido() +
		          " | DNI: " + c.getDni() +   
		          " | Especialidad: " + c.getEspecialidad() +
		          " | minimoPlus: " + c.getPlusCategoria());
		  }
		  
		 
	}
}
