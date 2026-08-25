package modelo;

public class ItemPedido {
	private int id;
	private int cantidad;
	private Plato plato;
	private Pedido pedido;

	public ItemPedido() {}

	public ItemPedido(int cantidad, Plato plato) {
		this.plato = plato;
		this.cantidad = cantidad;
	}

	public int getId() {
		return id;
	}

	protected void setId(int id) {
		this.id = id;
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

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	@Override
	public String toString() {
		return "ItemPedido [id=" + id + ", cantidad=" + cantidad + ", plato=" + plato + "]";
	}



}
