package com.course.rabbitmqproducertwo;

import com.course.rabbitmqproducertwo.entity.DummyMessages;
import com.course.rabbitmqproducertwo.entity.InvoiceCreatedMessage;
import com.course.rabbitmqproducertwo.entity.InvoicePaidMessage;
import com.course.rabbitmqproducertwo.producer.DummyProducer;
import com.course.rabbitmqproducertwo.producer.InvoiceProducer;
import com.course.rabbitmqproducertwo.producer.MultiplePrefetchProducer;
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
    }
}
