package com.demo.secondary;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends MongoRepository<Manager, String> {

}
