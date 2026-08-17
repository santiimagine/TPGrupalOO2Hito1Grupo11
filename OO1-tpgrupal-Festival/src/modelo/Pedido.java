package modelo;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;

public class Pedido {
	private int id;
	private LocalDate fecha;
	private Festival festival;
	private List<ItemPedido> items;
	
	
	public Pedido(int id, LocalDate fecha,  Festival festival) throws Exception {
		this.setId(id);
		this.festival = festival;
		this.setFecha(fecha);
		this.items = new ArrayList<ItemPedido>();
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public List<ItemPedido> getItems() {
		return items;
	}
	public void setItems(List<ItemPedido> items) {
		this.items = items;
	}
	
	public Festival getFestival() {
	    return festival;
	}
	
	public boolean agregarItem(Plato plato, int cantidad)
	{
	    return items.add(new ItemPedido(cantidad, plato));
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
		return "Pedido [ Fecha = " + this.getFecha() + ", Festival = " + 
		this.getFestival().getNombre() + ", Items= " + this.getItems().toString() + " ]";
	}
	
	
}
