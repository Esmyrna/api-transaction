package spring_boot.desafio.transactionApi.infra.mappers;

import spring_boot.desafio.transactionApi.domain.entities.Transaction;
import spring_boot.desafio.transactionApi.infra.entities.TransactionEntity;

public class TransactionMapper {
    public static Transaction toDomain(TransactionEntity entity) {
        if (entity == null) return null;

        Transaction transaction = new Transaction();
        transaction.setId(entity.getId());
        transaction.setBalance(entity.getBalance());
        transaction.setPayer(UserMapper.toDomain(entity.getPayer()));
        transaction.setReceiver(UserMapper.toDomain(entity.getReceiver()));
        transaction.setTransactionDateTime(entity.getTransactionDateTime());

        return transaction;
    }

    public static TransactionEntity toEntity(Transaction transaction) {
        if (transaction == null) return null;

        TransactionEntity entity = new TransactionEntity();
        entity.setId(transaction.getId());
        entity.setBalance(transaction.getBalance());
        entity.setPayer(UserMapper.toEntity(transaction.getPayer()));
        entity.setReceiver(UserMapper.toEntity(transaction.getReceiver()));
        entity.setTransactionDateTime(transaction.getTransactionDateTime());

        return entity;
    }
}
