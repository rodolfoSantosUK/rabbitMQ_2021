package com.course.rabbitmqconsumertwo.consumer;

import com.course.rabbitmq.entity.InvoicePaidMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RabbitListener(queues = "q.invoice")
public class InvoiceConsumer {

    private static final Logger log = LoggerFactory.getLogger(InvoiceConsumer.class);

    @RabbitHandler
    public void handleInvoicePaid(InvoicePaidMessage invoicePaidMessage) throws InterruptedException {
        log.info("handleInvoicePaid: {}", invoicePaidMessage);
    }

//    @RabbitHandler
//    public void handleInvoiceCreated(InvoiceCreatedMessage invoiceCreatedMessage) throws InterruptedException {
//        log.info("handleInvoiceCreated: {}", invoiceCreatedMessage);
//    }

    @RabbitHandler(isDefault = true)
    public void handleDefault(Object message) throws InterruptedException {
        log.info("handleDefault: {}", message);
    }

}
