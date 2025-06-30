package spring_boot.desafio.transactionApi.infra.clients.dtosClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(url = "https://util.devi.tools/api/v2/authorize", name = "authorization") // Lembrar de por no application properties
public interface ClientAuthorization {

   @GetMapping
   AuthorizationDTO checkAuto();

}