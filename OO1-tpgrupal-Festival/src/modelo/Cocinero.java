package modelo;

import java.time.LocalDate;

public class Cocinero extends Empleado {

	private String especialidad;
	private double plusCategoria;
	
	public Cocinero(){};

	public Cocinero(int id,
			String nombre,
			String apellido,
			String dni,
			LocalDate fechaNacimiento,
			LocalDate fechaIngreso,
			String especialidad,
			double plusCategoria) throws Exception {

		super(id, nombre, apellido, dni, fechaNacimiento, fechaIngreso);

		this.especialidad = especialidad;
		this.plusCategoria = plusCategoria;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public double getPlusCategoria() {
		return plusCategoria;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public void setPlusCategoria(double plusCategoria) {
		this.plusCategoria = plusCategoria;
	}

	@Override
	public double calcularSueldo() {

		return Constantes.SUELDO_BASE + plusCategoria;
	}
	@Override
	public String toString() {
		return super.toString() + ", Especialidad = " + this.getEspecialidad() + "] ";
	}
}