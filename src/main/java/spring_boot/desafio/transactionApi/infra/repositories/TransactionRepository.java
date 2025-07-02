package spring_boot.desafio.transactionApi.infra.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring_boot.desafio.transactionApi.domain.entities.Transaction;
import spring_boot.desafio.transactionApi.infra.entities.TransactionEntity;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {
    
}
