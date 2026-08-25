package modelo;
import java.util.Set;
import java.util.HashSet;
import java.time.LocalDate;

public class Pedido {
	private int id;
	private LocalDate fecha;
	private Festival festival;
	private UnidadVenta unidadVenta;
	private Set<ItemPedido> items;

	public Pedido() {}

	public Pedido(LocalDate fecha,  Festival festival, UnidadVenta unidadVenta) throws Exception {
		this.festival = festival;
		this.unidadVenta = unidadVenta;
		this.setFecha(fecha);
		this.items = new HashSet<ItemPedido>();
	}


	public int getId() {
		return id;
	}
	protected void setId(int id) {
		this.id = id;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) throws Exception {

	    if(fecha.isBefore(this.festival.getFechaInicio()) || fecha.isAfter(this.festival.getFechaFin()))
	    {
	        throw new Exception("La fecha del pedido debe estar comprendida entre " + this.festival.getFechaInicio() + " y " + this.festival.getFechaFin());
	    }

	    this.fecha = fecha;
	}

	public Set<ItemPedido> getItems() {
		return items;
	}
	public void setItems(Set<ItemPedido> items) {
		this.items = items;
	}

	public Festival getFestival() {
	    return festival;
	}

	public UnidadVenta getUnidadVenta() {
	    return unidadVenta;
	}

	public boolean agregarItem(Plato plato, int cantidad)
	{
	    ItemPedido item = new ItemPedido(cantidad, plato);
	    item.setPedido(this);
	    return items.add(item);
	}

	public double calcularTotal()
	{
	    double total = 0;

	    for(ItemPedido item : items)
	    {
	        total += item.getPlato().getPrecioVenta()
	                * item.getCantidad();
	    }

	    return total;
	}


	@Override
	public String toString() {
		return "Pedido [id=" + id + ", fecha=" + fecha + ", festival=" + festival + ", unidadVenta="
				+ unidadVenta + "]";
	}

}
