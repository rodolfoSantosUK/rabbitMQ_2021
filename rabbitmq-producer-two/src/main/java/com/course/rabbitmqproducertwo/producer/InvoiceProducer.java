package com.course.rabbitmqproducertwo.producer;

import com.course.rabbitmqproducertwo.entity.DummyMessages;
import com.course.rabbitmqproducertwo.entity.InvoiceCreatedMessage;
import com.course.rabbitmqproducertwo.entity.InvoicePaidMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private static final String EXCHANGE = "x.invoice";

    public void sendInvoiceCreated(InvoiceCreatedMessage message) {
        rabbitTemplate.convertAndSend(EXCHANGE, "", message);
    }

    public void sendInvoicePaid(InvoicePaidMessage message) {
        rabbitTemplate.convertAndSend(EXCHANGE, "", message);
    }

}
