package com.desafio.itau.spring.service;

import com.desafio.itau.spring.dto.StatisticsResponseDto;
import com.desafio.itau.spring.model.Transaction;

public interface TransactionService {
    Transaction saveTransaction(Transaction transaction);
    StatisticsResponseDto getStatisticsOfLast60Seconds();
    void deleteAllTransactions();
}
