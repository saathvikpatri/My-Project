package com.niit.shoppingcart.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Supplier;


@Repository("supplierDAO")
public class SupplierDAOImpl implements SupplierDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public SupplierDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
    @Transactional //javax.transaction
	public void saveOrUpdate(Supplier supplier) {
		sessionFactory.getCurrentSession().saveOrUpdate(supplier);
			
		}
	
    @Transactional
	public void delete(String id) {
		Supplier supplier = new Supplier();
		supplier.setId(id);
		sessionFactory.getCurrentSession().delete(supplier);
	}
   
    @Transactional
	public Supplier get(String id) {
		String hql = "from supplier where id = " + " ' " + id + " ' ";

		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Supplier> listSupplier = (List<Supplier>)query.list();

		if (listSupplier != null && listSupplier.isEmpty()) {
			return listSupplier.get(0);
		}
		return null;
    }
			
    @Transactional
	public List<Supplier> list() {
		String hql = "from Supplier";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Supplier> listSupplier = (List<Supplier>)query.list();
		return listSupplier ;
	}

	public boolean save(Supplier supplier) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean update(Supplier supplier) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(Supplier supplier) {
		// TODO Auto-generated method stub
		return false;
	}
}
