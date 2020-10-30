package com.testtask.customerwriter.service;

import com.testtask.customerwriter.dto.CustomerDto;
import com.testtask.customerwriter.entity.Customer;
import com.testtask.customerwriter.repo.CustomerRepo;
import com.testtask.customerwriter.util.RandomCustomerGenerator;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.logging.Logger;

@org.springframework.stereotype.Service
public class CustomerService implements Runnable {

    @Autowired
    CustomerRepo customerRepo;

    private int counterOfIterations=0;
    Logger log = Logger.getLogger(CustomerService.class.getName());


    public void createCustomer(){
        CustomerDto customerDto = new CustomerDto();
        customerDto.setFirstName(RandomCustomerGenerator.getRandomFirstName());
        customerDto.setLastName(RandomCustomerGenerator.getRandomLastName());
        customerDto.setCreated(LocalDateTime.now());
        customerRepo.save(new Customer(customerDto));
        log.info(customerDto.toString());
    }

    @Override
    public void run() {
        LocalDateTime finish = LocalDateTime.now().plusMinutes(10);
        while (LocalDateTime.now().isBefore(finish)){
            createCustomer();
            counterOfIterations++;
            try {
                Thread.sleep(RandomCustomerGenerator.getRandomSec()*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        log.info("Total amount of iterations: "+counterOfIterations);
    }
}
