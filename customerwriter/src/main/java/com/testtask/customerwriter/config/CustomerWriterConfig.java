package com.testtask.customerwriter.config;

import com.testtask.customerwriter.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class CustomerWriterConfig {

    @Autowired
    CustomerService customerService;

    @Bean
    public void customerWriterRunner() throws InterruptedException {
       new Thread(customerService).start();
    }

}
