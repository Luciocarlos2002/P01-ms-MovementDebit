package com.microservice.movementDebit.repository;

import com.microservice.movementDebit.model.MovementDebit;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface movementDebitRepository extends ReactiveCrudRepository<MovementDebit, String>{
}
