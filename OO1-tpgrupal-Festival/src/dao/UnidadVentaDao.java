package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.annotations.Where;
import org.hibernate.Hibernate;

import modelo.Empleado;
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
	
	public UnidadVenta traerConPlatos(int idUnidadVenta) throws HibernateException {
	    UnidadVenta objeto = null;
	    try {
	        iniciaOperacion();
	        String hql = "from UnidadVenta u where u.id=:idUnidadVenta";
	        objeto = (UnidadVenta) session.createQuery(hql).setParameter("idUnidadVenta", idUnidadVenta).uniqueResult();
	        Hibernate.initialize(objeto.getPlatos());
	    } finally {
	        session.close();
	    }
	    return objeto;
	}
	
	public List<Empleado> traerPersonal (int idUnidadVenta) throws HibernateException {
		List<Empleado> listaEmpleados = null;
		try {
			iniciaOperacion();
			listaEmpleados = session.createQuery("select e from UnidadVenta uv join uv.personal e" + 
					" where uv.id = :idUnidadVenta", 
					Empleado.class)
					.setParameter("idUnidadVenta", idUnidadVenta)
					.list();
		} finally {
			session.close();
		}
		return listaEmpleados;
	}
	
	public Empleado traerResponsable (int idUnidadVenta) throws HibernateException{
		Empleado responsable = null;
		try {
			iniciaOperacion();
			responsable = session.createQuery("select uv.responsable from UnidadVenta uv" +
			" where uv.id = :idUnidadVenta",
			Empleado.class)
					.setParameter("idUnidadVenta", idUnidadVenta)
					.uniqueResult();
		} finally {
			session.close();
		}
		return responsable;
	}

}