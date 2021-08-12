package org.productor;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class Application_Productor {
    public static void main(String[] args) {
        SpringApplication.run(Application_Productor.class, args);
    }
}
