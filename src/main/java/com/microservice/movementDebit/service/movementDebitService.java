package com.microservice.movementDebit.service;

import com.microservice.movementDebit.model.movementDebit;
import com.microservice.movementDebit.repository.movementDebitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class movementDebitService {

    private  final movementDebitRepository movementDebitRepository;

    public Flux<movementDebit> getAllCreditMovement(){
        return movementDebitRepository.findAll();
    }
    public Mono<movementDebit> getCreditMovementById(String id){
        return  movementDebitRepository.findById(id);
    }
    public Mono<movementDebit> createCreditMovement(movementDebit creditMovement){
        return movementDebitRepository.save(creditMovement);
    }
    public Mono<movementDebit> updateCreditMovement(String id, movementDebit creditMovement){
        return movementDebitRepository.findById(id)
                .flatMap(bean -> {
                    bean.setAmount(creditMovement.getAmount());
                    bean.setDateStart(creditMovement.getDateStart());
                    bean.setDateLimit(creditMovement.getDateLimit());
                    bean.setCommission(creditMovement.getCommission());
                    bean.setDescription(creditMovement.getDescription());
                    bean.setIdAccountCustomer(creditMovement.getIdAccountCustomer());
                    bean.setIdAccountDestination(creditMovement.getIdAccountDestination());
                    return movementDebitRepository.save(bean);
                });
    }
    public Mono<movementDebit> deleteCreditMovement(String id){
        return movementDebitRepository.findById(id)
                .flatMap(existsCreditMovement -> movementDebitRepository.delete(existsCreditMovement)
                        .then(Mono.just(existsCreditMovement)));
    }

}
