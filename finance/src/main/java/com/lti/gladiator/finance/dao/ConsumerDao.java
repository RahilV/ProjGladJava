package com.lti.gladiator.finance.dao;

import java.util.List;

import com.lti.gladiator.finance.beans.Consumer;

public interface ConsumerDao {
	
	public abstract List<Consumer> getAllConsumers();
	public abstract Consumer createConsumer(Consumer consumer);
	public abstract Consumer getConsumerById(int userId);
}
