package com.lti.gladiator.finance.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.gladiator.finance.beans.Consumer;
import com.lti.gladiator.finance.dao.ConsumerDao;

@Service("consumerService")
public class ConsumerServiceImpl implements ConsumerService{

	@Autowired
	private ConsumerDao consumerDao;
	
	public ConsumerDao getConsumerDao() {
		return consumerDao;
	}

	public void setConsumerDao(ConsumerDao consumerDao) {
		this.consumerDao = consumerDao;
	}

	@Override
	public Consumer createConsumer(Consumer consumer) {
		return consumerDao.createConsumer(consumer);
	}

	@Override
	public List<Consumer> getAllConsumers() {
		return consumerDao.getAllConsumers();
	}

	@Override
	public Consumer getConsumerById(int userId) {
		return consumerDao.getConsumerById(userId);
	}

	@Override
	public List<Consumer> getAllNonValidConsumers() {
		return consumerDao.getAllNonValidConsumers();
	}

}
