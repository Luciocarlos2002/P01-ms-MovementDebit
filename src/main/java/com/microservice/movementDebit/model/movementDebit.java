package com.microservice.movementDebit.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class movementDebit {

    @Id
    private String id;
    private double amount;
    private String dateStart;
    private String dateLimit;
    private String commission;
    private String description;
    private String idAccountCustomer;
    private String idAccountDestination;

}
