package com.course.rabbitmq.entity;

import com.course.rabbitmqproducertwo.json.CustomLocalDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.time.LocalDate;

public class InvoiceCanceledMessage {

    private String invoiceNumber;

    @JsonSerialize(using = CustomLocalDateSerializer.class)
    private LocalDate cancelDate;

    private String reason;

    public InvoiceCanceledMessage(String invoiceNumber, LocalDate cancelDate, String reason) {
        this.invoiceNumber = invoiceNumber;
        this.cancelDate = cancelDate;
        this.reason = reason;
    }

    public InvoiceCanceledMessage() {
    }

    @Override
    public String toString() {
        return "InvoiceCanceledMessage{" +
                "invoiceNumber='" + invoiceNumber + '\'' +
                ", cancelDate=" + cancelDate +
                ", reason='" + reason + '\'' +
                '}';
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public LocalDate getCancelDate() {
        return cancelDate;
    }

    public void setCancelDate(LocalDate cancelDate) {
        this.cancelDate = cancelDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
