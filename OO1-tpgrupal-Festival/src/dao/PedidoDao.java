package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import modelo.Pedido;
import modelo.Plato;

public class PedidoDao {
	private static Session session;
	private Transaction tx;

	private static PedidoDao instancia = null;

	protected PedidoDao() {}

	public static PedidoDao getInstance() {
		if (instancia == null)
			instancia = new PedidoDao();
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

	public int agregar(Pedido objeto) {
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

	public void actualizar(Pedido objeto) {
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

	public void eliminar(Pedido objeto) {
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

	public Pedido traer(int idPedido) {
		Pedido objeto = null;
		try {
			iniciaOperacion();
			objeto = (Pedido) session.createQuery("from Pedido p where p.id=:idPedido")
						.setParameter("idPedido", idPedido).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}

	public List<Pedido> traer() throws HibernateException {
		List<Pedido> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Pedido", Pedido.class).list();
		} finally {
			session.close();
		}
		return lista;
	}
	
		

}
