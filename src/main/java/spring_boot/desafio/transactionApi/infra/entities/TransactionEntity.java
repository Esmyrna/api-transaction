package spring_boot.desafio.transactionApi.infra.entities;

import jakarta.persistence.*;
import lombok.*;
import spring_boot.desafio.transactionApi.domain.entities.User;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "transaction")
@Builder
public class TransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal balance;
    @JoinColumn(name = "payer_id")
    @ManyToOne
    private UserEntity payer;
    @JoinColumn(name = "receiver_id")
    @ManyToOne
    private UserEntity receiver;
    private LocalDateTime transactionDateTime;
    @PrePersist
    void PrePersist(){
        transactionDateTime = LocalDateTime.now();
    }
}
