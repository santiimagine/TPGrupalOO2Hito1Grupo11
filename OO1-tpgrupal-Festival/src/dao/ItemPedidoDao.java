package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import modelo.ItemPedido;
import modelo.Plato;

public class ItemPedidoDao {
	private static Session session;
	private Transaction tx;

	private static ItemPedidoDao instancia = null;

	protected ItemPedidoDao() {}

	public static ItemPedidoDao getInstance() {
		if (instancia == null)
			instancia = new ItemPedidoDao();
		return instancia;
	}

	protected void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	protected void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}

	public int agregar(ItemPedido objeto) {
		int id = 0;
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(objeto).toString());
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
		} finally {
			session.close();
		}
		return id;
	}

	public void actualizar(ItemPedido objeto) {
		try {
			iniciaOperacion();
			session.update(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
		} finally {
			session.close();
		}
	}

	public void eliminar(ItemPedido objeto) {
		try {
			iniciaOperacion();
			session.delete(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
		} finally {
			session.close();
		}
	}

	public ItemPedido traer(int idItemPedido) {
		ItemPedido objeto = null;
		try {
			iniciaOperacion();
			objeto = (ItemPedido) session.createQuery("from ItemPedido p where p.id=:idItemPedido")
						.setParameter("idItemPedido", idItemPedido).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}

	public List<ItemPedido> traer() throws HibernateException {
		List<ItemPedido> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from ItemPedido", ItemPedido.class).list();
		} finally {
			session.close();
		}
		return lista;
	}
	
	public Object[] traerPlatoMasPedido (int idFestival) throws HibernateException {
		Object[] resultado = null;
		
		try {
			iniciaOperacion();
			resultado = (Object[]) session.createQuery(
					"select ip.plato, sum(ip.cantidad) from ItemPedido ip" +
					" where ip.pedido.festival.id = :idFestival" +
					" group by ip.plato" +
					" order by sum(ip.cantidad) desc"
					).setParameter("idFestival", idFestival)
					.setMaxResults(1)
					.uniqueResult();
			
		} finally {
			session.close();
		}
		
		return resultado;
		
	}

}
