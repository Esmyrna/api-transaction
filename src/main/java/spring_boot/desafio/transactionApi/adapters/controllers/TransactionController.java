package spring_boot.desafio.transactionApi.adapters.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import spring_boot.desafio.transactionApi.application.dtos.TransactionDTO;
import spring_boot.desafio.transactionApi.application.usecases.TransactionUseCase;

@RestController
@RequiredArgsConstructor
@RequestMapping("/transfer")
public class TransactionController {
    
    private final TransactionUseCase transactionUseCase;

    @PostMapping
    public ResponseEntity<Void> makeTransaction(@RequestBody TransactionDTO transaction){
        transactionUseCase.transferValues(transaction);
        return ResponseEntity.accepted().build();
    }
}
