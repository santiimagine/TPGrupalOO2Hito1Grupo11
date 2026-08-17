package modelo;

import java.time.LocalDate;

public class Cajero extends Empleado {

	private Turno turno;

	public Cajero(int id,
			String nombre,
			String apellido,
			String dni,
			LocalDate fechaNacimiento,
			LocalDate fechaIngreso,
			Turno turno) throws Exception {

		super(id, nombre, apellido, dni, fechaNacimiento, fechaIngreso);

		this.turno = turno;
	}

	public Turno getTurno() {
		return turno;
	}

	@Override
	public double calcularSueldo() {
		return Constantes.SUELDO_BASE +(calcularAntiguedad() * Constantes.PLUS_ANTIGUEDAD_POR_ANIO);
	}
	
	@Override
	public String toString() {
		return super.toString() + ", Turno= "+ this.getTurno() + "]";
	}

}