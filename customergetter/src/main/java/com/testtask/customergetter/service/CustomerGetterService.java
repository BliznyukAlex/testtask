package com.testtask.customergetter.service;

import com.testtask.customergetter.entity.Customer;
import com.testtask.customergetter.hash.CustomerHash;
import com.testtask.customergetter.repo.CustomerRepo;
import com.testtask.customergetter.repo.RedisCustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class CustomerGetterService implements Runnable{

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    RedisCustomerRepo redisCustomerRepo;

    Logger log = Logger.getLogger(CustomerGetterService.class.getName());
    private List<Customer> customersFromDB = new ArrayList<>();
    private int counterNewCustomersNotFound = 0;
    private int counterNewCustomersFound = 0;
    private int counterOfIterations=0;

    @Override
    public void run() {
        LocalDateTime finish = LocalDateTime.now().plusMinutes(10);
        ArrayList<CustomerHash> customerHashes = (ArrayList<CustomerHash>) redisCustomerRepo.findAll();
        LocalDateTime lastCustomerCreatedTime = null;
        while (LocalDateTime.now().isBefore(finish)) {
            log.info("--------------------iteration "+counterOfIterations+" ---------------------");
            if(customerHashes.isEmpty()&&counterOfIterations==0) {
                customersFromDB = customerRepo.findAll();
                if(!customersFromDB.isEmpty()) {
                    for (Customer customer : customersFromDB) {
                        if (redisCustomerRepo.findById(customer.getId()).equals(Optional.empty())) {
                            redisCustomerRepo.save(new CustomerHash(customer));
                            lastCustomerCreatedTime = customer.getCreated();
                            log.info(customer.toString());
                            counterNewCustomersFound++;
                        }
                    }
                }
                else {
                    counterNewCustomersNotFound++;
                }
            }
            else {
                if(lastCustomerCreatedTime == null) {
                    if(!customerHashes.isEmpty()) {
                        lastCustomerCreatedTime = customerHashes.get(customerHashes.size() - 1).getCreated();
                    }
                }
                if(lastCustomerCreatedTime!=null) {
                    customersFromDB = customerRepo.findAllByCreatedAfter(lastCustomerCreatedTime);
                    if (!customersFromDB.isEmpty()) {
                        for (Customer customer : customersFromDB) {
                            if (redisCustomerRepo.findById(customer.getId()).equals(Optional.empty())) {
                                redisCustomerRepo.save(new CustomerHash(customer));
                                lastCustomerCreatedTime = customer.getCreated();
                                counterNewCustomersFound++;
                                log.info(customer.toString());
                            }
                        }
                    } else {
                        counterNewCustomersNotFound++;
                    }
                }
                else {
                    counterNewCustomersNotFound++;
                }
            }
            counterOfIterations++;
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        log.info("New customers were not found:  "+ counterNewCustomersNotFound);
        log.info("New customers were not found: "+ counterNewCustomersFound);
        log.info("Total amount of iterations: "+counterOfIterations);
    }
}
