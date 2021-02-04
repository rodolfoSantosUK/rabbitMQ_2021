package com.course.rabbitmq.entity;

import com.course.rabbitmqconsumertwo.json.CustomLocalDateDeserializer;
import com.course.rabbitmqconsumertwo.json.CustomLocalDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.time.LocalDate;

public class InvoiceRejectedMessage {

    private String invoiceNumber;

    @JsonDeserialize  (using = CustomLocalDateDeserializer.class)
    private LocalDate rejectedDate;

    private String reason;

    public InvoiceRejectedMessage() {
    }

    public InvoiceRejectedMessage(String invoiceNumber, LocalDate rejectedDate, String reason) {
        this.invoiceNumber = invoiceNumber;
        this.rejectedDate = rejectedDate;
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "InvoiceRejectedMessage{" +
                "invoiceNumber='" + invoiceNumber + '\'' +
                ", rejectedDate=" + rejectedDate +
                ", reason='" + reason + '\'' +
                '}';
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public LocalDate getRejectedDate() {
        return rejectedDate;
    }

    public void setRejectedDate(LocalDate rejectedDate) {
        this.rejectedDate = rejectedDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
