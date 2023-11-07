package com.picpay.PicPaySimplificado.repositories;

import com.picpay.PicPaySimplificado.domain.transaction.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
