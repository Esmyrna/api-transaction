package spring_boot.desafio.transactionApi.application.usecases;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import spring_boot.desafio.transactionApi.application.dtos.TransactionDTO;
import spring_boot.desafio.transactionApi.domain.entities.Transaction;
import spring_boot.desafio.transactionApi.domain.entities.User;
import spring_boot.desafio.transactionApi.domain.entities.Wallet;
import spring_boot.desafio.transactionApi.domain.enums.UserType;
import spring_boot.desafio.transactionApi.domain.exceptions.BadRequest;
import spring_boot.desafio.transactionApi.infra.repositories.TransactionRepository;

@Service
@RequiredArgsConstructor
public class TransactionUseCase {

    private final UserUseCase userUseCase;
    private final AuthorizationUseCase authorizationUseCase;
    private final WalletUseCase walletUseCase;
    private final TransactionRepository transactionRepository;
    private final ClientNotificationUseCase clientNotification;

                                                                                                                                                                                                                                                                                                                               @Transactional
    public void transferValues(TransactionDTO transactionDTO){
        User payer = userUseCase.findUserById(transactionDTO.payer());
        User payee = userUseCase.findUserById(transactionDTO.payee());

        checkLogistPayer(payer);
        checkUserBalance(payer, transactionDTO.value());
        checkTransfer();

        //Save balance in wallet
        payer.getWallet().setBalance(payer.getWallet().getBalance().subtract(transactionDTO.value()));
        updateBalanceWallet(payer.getWallet());

        payee.getWallet().setBalance(payer.getWallet().getBalance().add(transactionDTO.value()));
        updateBalanceWallet(payee.getWallet());

        Transaction transaction = Transaction.builder()
        .balance(transactionDTO.value())
        .payer(payer)
        .receiver(payee)
        .build();
        
        transactionRepository.save(transaction);
        sendNotification();

    }

    // Check userType of user
    private void checkLogistPayer(User user){
        try{
            if(user.getUserType().equals(UserType.LOGIST)){
                throw new IllegalArgumentException("Transação não autorizada para esse tipo de usuário");
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    // Check balance of user
    private void checkUserBalance(User user, BigDecimal value){
        try{
            if(user.getWallet().getBalance().compareTo(value) < 0){
                  throw new IllegalArgumentException("Transação não autorizada. Saldo insuficiente!");
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
     // Check transfer as "true" or "false" for API
     private void checkTransfer(){
        try{
            if(!authorizationUseCase.checkTransfer()){
                  throw new IllegalArgumentException("Transação não autorizada pela API!");
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private void updateBalanceWallet(Wallet wallet){
         walletUseCase.save(wallet);
    }

    private void sendNotification() {
        try{
            clientNotification.sendNotification();
        } catch (HttpClientErrorException e){
            throw new BadRequest("Erro ao enviar notificação");
        }
    }
}
