package modelo;

import java.util.Objects;

public class Costo {
    private static int contadorId = 0;
	private int id;
	private TipoCosto tipo;
	private double monto;

	public Costo(int id, TipoCosto tipo, double monto) {
		
		this.id = contadorId++;
		this.tipo = tipo;
		this.monto = monto;
	}

	public int getId() {
		return id;
	}

	public TipoCosto getTipo() {
		return tipo;
	}

	public double getMonto() {
		return monto;
	}

	public void setTipo(TipoCosto tipo) {
		this.tipo = tipo;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	@Override
	public String toString() {
		return "Costo [id=" + id +
				", tipo=" + tipo +
				", monto=" + monto + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	public boolean equals(Costo costo)
	{
	    return this.id == costo.getId();
	}


}
