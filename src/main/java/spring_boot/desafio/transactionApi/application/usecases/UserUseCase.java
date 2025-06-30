package spring_boot.desafio.transactionApi.application.usecases;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import spring_boot.desafio.transactionApi.domain.entities.User;
import spring_boot.desafio.transactionApi.domain.exceptions.UserNotFound;
import spring_boot.desafio.transactionApi.infra.repositories.UserRepository;

@Service
@RequiredArgsConstructor
public class UserUseCase {
    private final UserRepository userRepository;

    public User findUserById(Long id){
        return userRepository.findById(id)
        .orElseThrow(() -> new UserNotFound("Usuário não encontrado"));
    }
}
