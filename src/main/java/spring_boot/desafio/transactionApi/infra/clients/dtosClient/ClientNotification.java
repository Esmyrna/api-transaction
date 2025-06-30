package spring_boot.desafio.transactionApi.infra.clients.dtosClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(url = "https://util.devi.tools/api/v1/notify", name = "notification") 
public interface ClientNotification {
    @PostMapping("/notify")
    void sendNotification();
}
