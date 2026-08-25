package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import modelo.Festival;

public class FestivalDao {
	private static Session session;
	private Transaction tx;

	private static FestivalDao instancia = null;

	protected FestivalDao() {}

	public static FestivalDao getInstance() {
		if (instancia == null)
			instancia = new FestivalDao();
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

	public int agregar(Festival objeto) {
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

	public void actualizar(Festival objeto) {
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

	public void eliminar(Festival objeto) {
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

	public Festival traer(int idFestival) {
		Festival objeto = null;
		try {
			iniciaOperacion();
			objeto = (Festival) session.createQuery("from Festival f where f.id=:idFestival")
						.setParameter("idFestival", idFestival).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}

	public List<Festival> traer() throws HibernateException {
		List<Festival> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Festival", Festival.class).list();
		} finally {
			session.close();
		}
		return lista;
	}

}
