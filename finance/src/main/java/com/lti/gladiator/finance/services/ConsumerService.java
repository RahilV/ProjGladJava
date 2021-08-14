package com.lti.gladiator.finance.services;

import java.util.List;

import com.lti.gladiator.finance.beans.Consumer;

public interface ConsumerService {
	
	public abstract List<Consumer> getAllConsumers();
	public abstract Consumer createConsumer(Consumer consumer);
	public abstract Consumer getConsumerById(int userId);
}
