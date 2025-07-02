package spring_boot.desafio.transactionApi.domain.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Transaction {

    private Long id;
    private BigDecimal balance;
    private User payer;
    private User receiver;
    private LocalDateTime transactionDateTime;

}
