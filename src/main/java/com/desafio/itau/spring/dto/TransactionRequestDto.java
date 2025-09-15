package com.desafio.itau.spring.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.OffsetDateTime;

public record TransactionRequestDto(
        @NotNull double valor,
        @NotNull OffsetDateTime dataHora) {
}
