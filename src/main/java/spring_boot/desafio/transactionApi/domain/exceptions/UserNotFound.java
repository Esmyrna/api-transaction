package spring_boot.desafio.transactionApi.domain.exceptions;

public class UserNotFound extends RuntimeException {
    public UserNotFound(String message){
        super(message);
    }
}
