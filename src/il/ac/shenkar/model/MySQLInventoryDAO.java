package il.ac.shenkar.model;

import java.util.Collection;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class MySQLInventoryDAO implements InventoryDAO {

	private static MySQLInventoryDAO instance;
	private SessionFactory factory;

	public static MySQLInventoryDAO getInstance() {
		if (instance == null) {
			instance = new MySQLInventoryDAO();
		}
		return instance;
	}

	private MySQLInventoryDAO() {
		factory = new AnnotationConfiguration().configure()
				.buildSessionFactory();
	}

	@Override
	public Collection<Product> getProducts() throws InventoryException {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			List products = session.createQuery("from Product").list();
			tx.commit();
			return products;
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw new InventoryException("problem with getting all products",e);
		} finally {
			if(session!=null)session.close();
		}
	}

	@Override
	public boolean addProduct(Product product) throws InventoryException {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(product);
			tx.commit();
			return true;
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw new InventoryException("problem with adding "+product,e);
		} finally {
			if(session!=null)session.close();
		}
	}

}
