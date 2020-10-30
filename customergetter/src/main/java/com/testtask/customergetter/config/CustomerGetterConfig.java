package com.testtask.customergetter.config;

import com.testtask.customergetter.service.CustomerGetterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerGetterConfig {

    @Autowired
    CustomerGetterService customerService;

    @Bean
    public void customerGetterRunner() throws InterruptedException {
        new Thread(customerService).start();
    }
}
