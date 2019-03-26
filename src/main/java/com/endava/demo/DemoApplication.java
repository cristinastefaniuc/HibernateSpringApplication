package com.endava.demo;

import com.endava.demo.dao.impl.InternDAOImpl;
import com.endava.demo.entity.Intern;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

import static com.endava.demo.entity.InternStreams.JAVA;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);

    }
}
