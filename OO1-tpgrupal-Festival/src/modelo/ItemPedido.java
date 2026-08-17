package modelo;

public class ItemPedido {
	
	private int cantidad;
	private Plato plato;

	public ItemPedido(int cantidad, Plato plato) {
		this.plato = plato;
		this.cantidad = cantidad;
	}

	public int getCantidad() {
		return cantidad;
	}

	public Plato getPlato() {
		return plato;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public void setPlato(Plato plato) {
		this.plato = plato;
	}

	@Override
	public String toString() {
		return "\n ItemPedido [cantidad=" + cantidad +
				", plato=" + plato + "]";
	}

}
