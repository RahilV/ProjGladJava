package com.lti.gladiator.finance.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.lti.gladiator.finance.beans.ProductsPurchased;

@Repository("ProductsPurchased")
@EnableTransactionManagement
public class ProductsPurchasedDaoImpl implements ProductsPurchasedDao {

	@PersistenceContext
	EntityManager em;
	
	@Override
	public int saveProductsPurchased(ProductsPurchased pp) {
    System.out.println("\nDao Layer: "+pp);
		em.persist(pp);
		System.out.println("Record saved");
		return 0;
	}

	@Override
	public List<ProductsPurchased> getProductsPurchased() {
          System.out.println("\nGet Products Purchased: Dao layer");
		TypedQuery<ProductsPurchased> qry=em.createQuery("SELECT e FROM ProductsPurchased e",ProductsPurchased.class);		
		List<ProductsPurchased> ProductsPurchasedList= qry.getResultList();		
		return ProductsPurchasedList;
	
	}

	@Override
	public List<ProductsPurchased> getUserProductsPurchased(int userId) {
		System.out.println("USER ID:"+userId);
		String sql="SELECT p FROM ProductsPurchased p where p.userId = ?1";
		TypedQuery<ProductsPurchased> tq = em.createQuery(sql,ProductsPurchased.class);
		tq.setParameter(1, userId);
		List<ProductsPurchased> userProducts = tq.getResultList();
		System.out.println(userProducts);
		return userProducts;
	}
	
	@Override
	@Transactional
	public String buyProduct(ProductsPurchased pp){
	     em.persist(pp);
		 return "Buy Product";	
	}

	@Override
	public ProductsPurchased getPrdById(int productsPurchasedId) {
		System.out.println(em.find(ProductsPurchased.class, productsPurchasedId));
		return em.find(ProductsPurchased.class,productsPurchasedId);
	}
	
	
}