package com.lti.gladiator.finance.services;

import java.util.List;

import com.lti.gladiator.finance.beans.EmiCard;

public interface EmiCardService {

	public long saveEmiCard(EmiCard ec);
	
	public List<EmiCard> getEmiCard();

	public EmiCard findEmiCardByNo(long cardNo);

}