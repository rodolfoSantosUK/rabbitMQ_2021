package com.course.rabbitmqproducertwo.producer;

import com.course.rabbitmq.entity.InvoiceCanceledMessage;
import com.course.rabbitmq.entity.InvoiceCreatedMessage;
import com.course.rabbitmq.entity.InvoicePaidMessage;
import com.course.rabbitmq.entity.InvoiceRejectedMessage;
import com.course.rabbitmq.entity.*;
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

    public void sendInvoiceRejected(InvoiceRejectedMessage message) {
        rabbitTemplate.convertAndSend(EXCHANGE, "", message);
    }


    public void sendInvoiceCanceled(InvoiceCanceledMessage message) {
        rabbitTemplate.convertAndSend(EXCHANGE, "", message);
    }


}
