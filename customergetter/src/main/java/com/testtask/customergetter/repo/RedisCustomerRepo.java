package com.testtask.customergetter.repo;

import com.testtask.customergetter.hash.CustomerHash;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedisCustomerRepo extends CrudRepository<CustomerHash,Integer> {
    CustomerHash findLastCustomerHashByIdDesc();
}
