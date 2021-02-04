package com.course.rabbitmq.entity;

import com.course.rabbitmqconsumertwo.json.CustomLocalDateDeserializer;
import com.course.rabbitmqconsumertwo.json.CustomLocalDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.time.LocalDate;

public class InvoicePaidMessage {

    private String invoiceNumber;

    @JsonDeserialize(using = CustomLocalDateDeserializer.class)
    private LocalDate paidDate;

    private String paymentNumber;

    public InvoicePaidMessage(String invoiceNumber, LocalDate paidDate, String paymentNumber) {
        this.invoiceNumber = invoiceNumber;
        this.paidDate = paidDate;
        this.paymentNumber = paymentNumber;
    }

    @Override
    public String toString() {
        return "InvoicePaidMessage{" +
                "invoiceNumber='" + invoiceNumber + '\'' +
                ", paidDate=" + paidDate +
                ", paymentNumber='" + paymentNumber + '\'' +
                '}';
    }

    public InvoicePaidMessage() {
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public LocalDate getPaidDate() {
        return paidDate;
    }

    public void setPaidDate(LocalDate paidDate) {
        this.paidDate = paidDate;
    }

    public String getPaymentNumber() {
        return paymentNumber;
    }

    public void setPaymentNumber(String paymentNumber) {
        this.paymentNumber = paymentNumber;
    }
}
