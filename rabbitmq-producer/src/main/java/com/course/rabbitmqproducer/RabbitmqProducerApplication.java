package com.course.rabbitmqproducer;

import com.course.rabbitmqproducer.entity.Employee;
import com.course.rabbitmqproducer.entity.Picture;
import com.course.rabbitmqproducer.producer.EmployeeJsonProducer;
import com.course.rabbitmqproducer.producer.HelloRabbitProducer;
import com.course.rabbitmqproducer.producer.HumanResourceProducer;
import com.course.rabbitmqproducer.producer.PictureProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
//@EnableScheduling
public class RabbitmqProducerApplication implements CommandLineRunner {

//	@Autowired
//	private HelloRabbitProducer helloRabbitProducer;

    @Autowired
    private PictureProducer pictureProducer ;

    private List<String> SOURCES  = List.of("mobile", "web");
    private List<String> TYPES  = List.of("jpg", "png", "svg");

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqProducerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 5; i++) {
            var p = new Picture( );
            p.setName("Picture " + i);
            p.setSize(5);
            p.setSource(SOURCES.get(i % SOURCES.size()));
            p.setType(TYPES.get(i % TYPES.size()));

            pictureProducer.sendMessage(p);
        }
    }
}
