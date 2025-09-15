package com.desafio.itau.spring.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.OffsetDateTime;

public record TransactionRequestDto(
        @NotNull @Min(0) double valor,
        @NotNull OffsetDateTime dataHora) {
}
