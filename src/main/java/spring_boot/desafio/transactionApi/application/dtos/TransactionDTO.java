package spring_boot.desafio.transactionApi.application.dtos;

import java.math.BigDecimal;

public record TransactionDTO(BigDecimal value, Long payer, Long payee) {
    
}
