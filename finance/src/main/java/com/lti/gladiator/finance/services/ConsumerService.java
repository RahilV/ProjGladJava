package com.lti.gladiator.finance.services;

import java.util.List;

import com.lti.gladiator.finance.beans.Consumer;

public interface ConsumerService {
	
	public abstract List<Consumer> getAllConsumers();
	public abstract List<Consumer> getAllNonValidConsumers();
	public abstract Consumer createConsumer(Consumer consumer);
	public abstract String deleteConsumer(int userId);
	public abstract Consumer getConsumerById(int userId);
	public abstract Consumer validateConsumer(int userId);
	public abstract Consumer editConsumer(Consumer consumer);
	
}
