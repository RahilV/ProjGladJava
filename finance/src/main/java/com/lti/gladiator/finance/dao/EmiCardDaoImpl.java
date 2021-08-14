package com.lti.gladiator.finance.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.lti.gladiator.finance.beans.EmiCard;

@Repository("emiCardDao")
@EnableTransactionManagement
public class EmiCardDaoImpl implements EmiCardDao {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public long saveEmiCard(EmiCard ec) {
		System.out.println("\nDao Layer: "+ec);
		
		em.persist(ec);
		
		System.out.println("Record saved");
		return ec.getCardNo();
	}
	
	@Override
	public List<EmiCard> getEmiCard() {
		System.out.println("\nGet Emi Card: Dao layer");
		
		TypedQuery<EmiCard> qry=em.createQuery("SELECT e FROM EmiCard e",EmiCard.class);		
		List<EmiCard> emiCardList= qry.getResultList();		
		
		return emiCardList;
	}

	@Override
	public EmiCard findEmiCardByNo(long cardNo) {
		EmiCard ec = em.find(EmiCard.class,cardNo);
		System.out.println(ec);
		return ec;
	}	

}