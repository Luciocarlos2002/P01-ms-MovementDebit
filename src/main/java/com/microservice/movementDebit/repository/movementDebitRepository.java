package com.microservice.movementDebit.repository;

import com.microservice.movementDebit.model.movementDebit;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface movementDebitRepository extends ReactiveCrudRepository<movementDebit, String>{
}
