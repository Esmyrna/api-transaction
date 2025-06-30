package spring_boot.desafio.transactionApi.domain.exceptions;

public class BadRequest extends RuntimeException {
    public BadRequest(String message){
        super(message);
    }
}
