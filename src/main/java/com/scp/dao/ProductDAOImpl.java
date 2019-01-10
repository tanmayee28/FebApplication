package com.scp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.scp.entities.ProductEntity;
import com.scp.util.SessionFactoryUtil;

public class ProductDAOImpl implements ProductDAO{

	
	@Override
	public ProductEntity addProduct(ProductEntity product) {
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.save(product);
		session.flush();
		tr.commit();
		return product;
	}

	@Override
	public ProductEntity getProduct(int productId) {
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		ProductEntity entity = session.get(ProductEntity.class, productId);
		session.close();
		return entity;
	}

	@Override
	public int deleteProduct(int productId) {
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.delete(getProduct(productId));
		session.flush();
		tr.commit();
		session.close();
		return productId;
	}

	@Override
	public ProductEntity updateProduct(ProductEntity product) {
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.update(product);
		session.flush();
		tr.commit();
		session.close();
		return getProduct(product.getProductId());
	}

	@Override
	public List<ProductEntity> getAllProducts() {
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		List<ProductEntity> productEntities = session.createQuery("from ProductEntity").list();
		session.close();
		return productEntities;
	}

}
