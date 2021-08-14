package com.lti.gladiator.finance.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.gladiator.finance.beans.EmiCard;
import com.lti.gladiator.finance.dao.EmiCardDao;

@Service("emiCardService")
public class EmiCardServiceImpl implements EmiCardService {

	@Autowired
	private EmiCardDao emiCardDao;
		
	public EmiCardDao getEmiCardDao() {
		return emiCardDao;
	}

	public void setEmiCardDao(EmiCardDao emiCardDao) {
		this.emiCardDao = emiCardDao;
	}

	@Override
	public long saveEmiCard(EmiCard ec) {
		System.out.println("\nService Layer: "+ec);
		emiCardDao.saveEmiCard(ec);
		return ec.getCardNo();
	}
	
	@Override
	public List<EmiCard> getEmiCard() {
		System.out.println("\nGet Emi Card: Service Layer");
		return emiCardDao.getEmiCard();

}

	@Override
	public EmiCard findEmiCardByNo(long cardNo) {
		return emiCardDao.findEmiCardByNo(cardNo);

	}

}