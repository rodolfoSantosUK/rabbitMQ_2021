package com.course.rabbitmqproducertwo;

import com.course.rabbitmq.entity.InvoiceCanceledMessage;
import com.course.rabbitmq.entity.InvoiceCreatedMessage;
import com.course.rabbitmq.entity.InvoicePaidMessage;
import com.course.rabbitmq.entity.InvoiceRejectedMessage;
import com.course.rabbitmqproducertwo.producer.InvoiceProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

@SpringBootApplication
public class RabbitmqProducerTwoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqProducerTwoApplication.class, args);
    }

    @Autowired
    private InvoiceProducer producer;


    @Override
    public void run(String... args) throws Exception {
        var randomInvoiceNumber = "INV-" + ThreadLocalRandom.current().nextInt(100, 200);
        var invoiceCreatedMessage = new InvoiceCreatedMessage(145.23, LocalDate.now(), "USD", randomInvoiceNumber);
        producer.sendInvoiceCreated(invoiceCreatedMessage);

        randomInvoiceNumber = "INV-" + ThreadLocalRandom.current().nextInt(200, 300);
        var randomPaymentNumber = "PAY-" + ThreadLocalRandom.current().nextInt(2000, 3000);
        var invoicePaidMessage = new InvoicePaidMessage(randomInvoiceNumber, LocalDate.now(), randomPaymentNumber);
        producer.sendInvoicePaid(invoicePaidMessage);


        randomInvoiceNumber = "INV-" + ThreadLocalRandom.current().nextInt(300, 400);
        var invoiceCanceledMessage = new InvoiceCanceledMessage( randomInvoiceNumber, LocalDate.now(), "Just cancel it");
        producer.sendInvoiceCanceled(invoiceCanceledMessage);

        randomInvoiceNumber = "INV-" + ThreadLocalRandom.current().nextInt(300, 400);
        var invoiceRejectedMessage = new InvoiceRejectedMessage( randomInvoiceNumber, LocalDate.now(), "Jusr reject it");
        producer.sendInvoiceRejected(invoiceRejectedMessage);
    }
}
