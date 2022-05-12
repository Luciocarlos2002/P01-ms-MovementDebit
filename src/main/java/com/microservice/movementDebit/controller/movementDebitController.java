package com.microservice.movementDebit.controller;

import com.microservice.movementDebit.model.movementDebit;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movementDebit")
public class movementDebitController {

    private final com.microservice.movementDebit.service.movementDebitService movementDebitService;

    @GetMapping
    public Mono<ResponseEntity<Flux<movementDebit>>>getAllCreditMovement() {
        Flux<movementDebit> list=this.movementDebitService.getAllCreditMovement();
        return  Mono.just(ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(list));
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<movementDebit>> getCreditMovementById(@PathVariable String id){
        var creditMovement=this.movementDebitService.getCreditMovementById(id);
        return creditMovement.map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<movementDebit> create(@RequestBody movementDebit account){
        return this.movementDebitService.createCreditMovement(account);
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<movementDebit>> updateCreditMovementById(@PathVariable String id, @RequestBody movementDebit movementDebit){

        return this.movementDebitService.updateCreditMovement(id,movementDebit)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> deleteCreditMovementById(@PathVariable String id){
        return this.movementDebitService.deleteCreditMovement(id)
                .map(r -> ResponseEntity.ok().<Void>build())
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

}
