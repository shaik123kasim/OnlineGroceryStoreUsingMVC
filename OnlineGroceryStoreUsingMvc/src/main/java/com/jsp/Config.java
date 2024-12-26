package com.jsp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

@Configuration
@ComponentScan(basePackages = "com.jsp")
public class Config {
        @Bean
        public EntityManager getEntityManager(){
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
            EntityManager manager = factory.createEntityManager();
            return manager;
        }
        @Bean
        public EntityTransaction getEntityTransaction(){
            EntityTransaction transaction = getEntityManager().getTransaction();
            return transaction;
        }
}
