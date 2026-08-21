package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import modelo.Plato;

public class PlatoDao {
	private static Session session;
	private Transaction tx;

	private static PlatoDao instancia = null;

	protected PlatoDao() {}

	public static PlatoDao getInstance() {
		if (instancia == null)
			instancia = new PlatoDao();
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

	public int agregar(Plato objeto) {
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

	public void actualizar(Plato objeto) {
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

	public void eliminar(Plato objeto) {
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

	public Plato traer(int idPlato) {
		Plato objeto = null;
		try {
			iniciaOperacion();
			objeto = (Plato) session.createQuery("from Plato p where p.idPlato=:idPlato")
						.setParameter("idPlato", idPlato).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}

	public List<Plato> traer() throws HibernateException {
		List<Plato> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Plato", Plato.class).list();
		} finally {
			session.close();
		}
		return lista;
	}

}
