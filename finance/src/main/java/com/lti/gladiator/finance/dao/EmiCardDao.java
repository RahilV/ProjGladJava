package com.lti.gladiator.finance.dao;

import java.util.List;

import com.lti.gladiator.finance.beans.EmiCard;

public interface EmiCardDao {
	
	public long saveEmiCard(EmiCard ec);

	public List<EmiCard> getEmiCard();

	public EmiCard findEmiCardByNo(long cardNo);

}