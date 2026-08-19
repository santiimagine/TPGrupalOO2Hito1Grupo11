package modelo;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public abstract class Empleado {

	private int id;
	protected String nombre;
	protected String apellido;
	protected String dni;
	protected LocalDate fechaNacimiento;
	protected LocalDate fechaIngreso;
	
	public Empleado(){};

	public Empleado(int id, String nombre, String apellido, String dni,
			LocalDate fechaNacimiento, LocalDate fechaIngreso) throws Exception {

		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.setFechaNacimiento(fechaNacimiento); 
		this.fechaIngreso = fechaIngreso;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getDni() {
		return dni;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}
	
	protected void setId(int id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) throws Exception {
		
		if(fechaNacimiento == null || Period.between(fechaNacimiento,LocalDate.now()).getYears() < 18)
		{
			throw new Exception("El empleado debe ser mayor de edad");
		}
		
		this.fechaNacimiento = fechaNacimiento;
	}

	public int calcularAntiguedad() {

		return Period.between(fechaIngreso, LocalDate.now()).getYears();
	}

	//METODO ABSTRACTO
	public abstract double calcularSueldo();


	@Override
	public String toString() {

		return "Empleado [id=" + id +
				", nombre=" + nombre +
				", apellido=" + apellido +		
				", dni=" + dni + "]";
	}



	public boolean equals(Empleado empleado)
	{
	    return this.dni.equals(empleado.getDni());
	}
	
	
	
}
