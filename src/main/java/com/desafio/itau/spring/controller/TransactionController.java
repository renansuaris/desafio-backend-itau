package com.desafio.itau.spring.controller;

import com.desafio.itau.spring.dto.StatisticsResponseDto;
import com.desafio.itau.spring.dto.TransactionRequestDto;
import com.desafio.itau.spring.model.Transaction;
import com.desafio.itau.spring.service.TransactionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;

@RestController
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping("/transacao")
    public ResponseEntity<Void> addTransaction(@Valid @RequestBody TransactionRequestDto dto) {
        if(dto.dataHora().isAfter(OffsetDateTime.now()) || dto.valor() <= 0){
            return ResponseEntity.unprocessableEntity().build();
        }
        transactionService.saveTransaction(new Transaction(dto.valor(), dto.dataHora()));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/transacao")
    public ResponseEntity<Void> clearTransactions() {
        transactionService.deleteAllTransactions();
        return ResponseEntity.ok().build();
    }

    @GetMapping("/estatistica")
    public ResponseEntity<StatisticsResponseDto> getStatistics() {
        StatisticsResponseDto statistics = transactionService.getStatisticsOfLast60Seconds();
        return ResponseEntity.ok(statistics);
    }

}
