package com.course.rabbitmqproducer.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.time.LocalDate;

public class Employee {

    @JsonProperty("employee_id")
    private String employeeId;

    private String name;


    public Employee() {

    }

    public Employee(String employeeId, String name ) {
        super();
        this.employeeId = employeeId;
        this.name = name;
    }


    public String getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }


    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee [employeeId=" + employeeId + ", name=" + name  ;
    }
}