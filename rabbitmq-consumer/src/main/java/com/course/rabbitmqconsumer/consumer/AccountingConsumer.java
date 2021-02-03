package com.course.rabbitmqconsumer.consumer;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import com.course.rabbitmqconsumer.entity.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;

//@Service
public class AccountingConsumer {

	private ObjectMapper objectMapper = new ObjectMapper();
	private static final Logger log = LoggerFactory.getLogger(AccountingConsumer.class);
	
	@RabbitListener(queues = "q.hr.accounting")
	public void listen(String message) {
		Employee emp = null;
		
		try {
			emp = objectMapper.readValue(message, Employee.class);
		} catch (IOException e) {
			e.printStackTrace();
		}

		log.info("On accounting, employee is {}", emp);
	}
	
}
