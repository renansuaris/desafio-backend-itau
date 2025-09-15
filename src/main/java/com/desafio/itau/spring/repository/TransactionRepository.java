package com.desafio.itau.spring.repository;

import com.desafio.itau.spring.model.Transaction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@Repository
public class TransactionRepository {

    private final Queue<Transaction> transactions = new ConcurrentLinkedQueue<>();

    public Transaction save(Transaction transaction) {
        transactions.add(transaction);
        return transaction;
    }

    public List<Transaction> findAll() {
        return new ArrayList<>(transactions);
    }

    public void deleteAll() {
        transactions.clear();
    }

}
