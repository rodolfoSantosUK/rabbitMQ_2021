package com.course.rabbitmqconsumer.consumer;

import com.course.rabbitmqconsumer.entity.Employee;
import com.course.rabbitmqconsumer.entity.Picture;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class SpringEmployeeConsumer {

    private ObjectMapper objectMapper = new ObjectMapper();
    private static final Logger log = LoggerFactory.getLogger(SpringEmployeeConsumer.class);

    @RabbitListener(queues = "q.spring2.accounting.work")
    public void listenAccountin(String  message)
            throws JsonParseException, JsonMappingException, IOException {
        var emp = objectMapper.readValue(message, Employee.class);
        if (emp.getName() ==  null) {
            log.error("On accounting name is empty: {}", emp);
            throw new IllegalArgumentException("Name is empty");
        }
        log.info("On accounting : {}", emp);
    }

    @RabbitListener(queues = "q.spring2.marketing.work")
    public void listenMarketing(String  message)
            throws JsonParseException, JsonMappingException, IOException {
        var emp = objectMapper.readValue(message, Employee.class);
        if (emp.getName() ==  null) {
            log.error("On accounting name is empty: {}", emp);
            throw new IllegalArgumentException("Name is empty");
        }
        log.info("On accounting : {}", emp);
    }

}
