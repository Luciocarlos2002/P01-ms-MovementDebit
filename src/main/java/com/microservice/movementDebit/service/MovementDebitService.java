package com.microservice.movementDebit.service;

import com.microservice.movementDebit.model.MovementDebit;
import com.microservice.movementDebit.repository.movementDebitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class MovementDebitService {

    private  final movementDebitRepository movementDebitRepository;

    public Flux<MovementDebit> getAllCreditMovement(){
        return movementDebitRepository.findAll();
    }
    public Mono<MovementDebit> getCreditMovementById(String id){
        return  movementDebitRepository.findById(id);
    }
    public Mono<MovementDebit> createCreditMovement(MovementDebit creditMovement){
        return movementDebitRepository.save(creditMovement);
    }
    public Mono<MovementDebit> updateCreditMovement(String id, MovementDebit creditMovement){
        return movementDebitRepository.findById(id)
                .flatMap(bean -> {
                    bean.setAmount(creditMovement.getAmount());
                    bean.setDateStart(creditMovement.getDateStart());
                    bean.setDateLimit(creditMovement.getDateLimit());
                    bean.setCommission(creditMovement.getCommission());
                    bean.setDescription(creditMovement.getDescription());
                    bean.setIdAccount(creditMovement.getIdAccount());
                    return movementDebitRepository.save(bean);
                });
    }
    public Mono<MovementDebit> deleteCreditMovement(String id){
        return movementDebitRepository.findById(id)
                .flatMap(existsCreditMovement -> movementDebitRepository.delete(existsCreditMovement)
                        .then(Mono.just(existsCreditMovement)));
    }

}
