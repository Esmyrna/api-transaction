package spring_boot.desafio.transactionApi.infra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import spring_boot.desafio.transactionApi.domain.entities.Wallet;

public interface WalletRepository extends JpaRepository<Wallet, Long>{
    
}
