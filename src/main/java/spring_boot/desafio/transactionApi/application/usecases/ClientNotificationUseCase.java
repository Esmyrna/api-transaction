package spring_boot.desafio.transactionApi.application.usecases;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring_boot.desafio.transactionApi.infra.clients.dtosClient.ClientNotification;

@Service
@RequiredArgsConstructor
public class ClientNotificationUseCase {
    @Autowired
    private ClientNotification clientNotification;

    public void sendNotification(){
        clientNotification.sendNotification();
    }
    
}
