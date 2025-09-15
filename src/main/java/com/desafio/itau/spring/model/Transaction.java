package com.desafio.itau.spring.model;

import lombok.*;

import java.time.OffsetDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Transaction {

    private double valor;
    private OffsetDateTime dataHora;

}
