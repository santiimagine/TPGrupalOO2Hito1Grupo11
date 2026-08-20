package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import modelo.UnidadVenta;

public class UnidadVentaDao {
	private static Session session;
	private Transaction tx;
	
	private static UnidadVentaDao instancia = null;
	
	protected UnidadVentaDao() {}
	
	public static UnidadVentaDao getInstance() {
		if (instancia == null)
			instancia = new UnidadVentaDao();
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
	
	/*public int agregar(UnidadVenta objeto) {
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
	}*/
	
	public UnidadVenta traer(int idUnidadVenta) {
		UnidadVenta objeto = null;
		try {
			iniciaOperacion();
			objeto = (UnidadVenta) session.createQuery("from UnidadVenta e where e.id=:idUnidadVenta")
						.setParameter("idUnidadVenta", idUnidadVenta).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}

	public List<UnidadVenta> traer() throws HibernateException {
		List<UnidadVenta> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from UnidadVenta", UnidadVenta.class).list();
		} finally {
			session.close();
		}
		return lista;
	}

}