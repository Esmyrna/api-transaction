package spring_boot.desafio.transactionApi.application.usecases;

import java.util.Objects;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import spring_boot.desafio.transactionApi.infra.clients.dtosClient.ClientAuthorization;

@Service
@RequiredArgsConstructor
public class AuthorizationUseCase {
    private final ClientAuthorization clientAuthorization;


     boolean checkTransfer(){
        if(Objects.equals(clientAuthorization.checkAuto().data().authorization(), "true")){
            return true;
        }
        return false;
        
    }
}
