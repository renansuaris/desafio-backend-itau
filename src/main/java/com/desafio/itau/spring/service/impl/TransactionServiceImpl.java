package com.desafio.itau.spring.service.impl;

import com.desafio.itau.spring.dto.StatisticsResponseDto;
import com.desafio.itau.spring.model.Transaction;
import com.desafio.itau.spring.repository.TransactionRepository;
import com.desafio.itau.spring.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;

    @Override
    public Transaction saveTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public StatisticsResponseDto getStatisticsOfLast60Seconds() {

        OffsetDateTime now = OffsetDateTime.now();

        DoubleSummaryStatistics stats =
                transactionRepository.findAll()
                .stream()
                .filter(t -> t.getDataHora().isAfter(now.minusSeconds(60)))
                .mapToDouble(Transaction::getValor)
                .summaryStatistics();

        return StatisticsResponseDto.from(stats);
    }

    @Override
    public void deleteAllTransactions() {
        transactionRepository.deleteAll();
    }
}
