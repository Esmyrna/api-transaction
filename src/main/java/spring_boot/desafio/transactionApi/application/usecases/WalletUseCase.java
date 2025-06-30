package spring_boot.desafio.transactionApi.application.usecases;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import spring_boot.desafio.transactionApi.domain.entities.Wallet;
import spring_boot.desafio.transactionApi.infra.repositories.WalletRepository;

@Service
@RequiredArgsConstructor
public class WalletUseCase {
    private final WalletRepository walletRepository;

    public void save(Wallet wallet){
       walletRepository.save(wallet);
    }
}
