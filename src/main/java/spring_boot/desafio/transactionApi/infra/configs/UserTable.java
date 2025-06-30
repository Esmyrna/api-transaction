package spring_boot.desafio.transactionApi.infra.configs;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import spring_boot.desafio.transactionApi.domain.entities.User;
import spring_boot.desafio.transactionApi.domain.entities.Wallet;
import spring_boot.desafio.transactionApi.domain.enums.UserType;
import spring_boot.desafio.transactionApi.infra.repositories.UserRepository;
import spring_boot.desafio.transactionApi.infra.repositories.WalletRepository;

import java.math.BigDecimal;
import java.util.List;

@Configuration
public class UserTable {
    @Bean
    CommandLineRunner saveData(UserRepository userRepository, WalletRepository walletRepository) {
        return args -> {
            if (userRepository.count() == 0) {
                BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

                User user1 = new User(null, "Carlos Silva", "carlos@email.com", "101111111111",
                        encoder.encode("123456"), null, UserType.COMMON);

                User user2 = new User(null, "Ana Souza", "ana@email.com", "22222222222",
                        encoder.encode("123456"), null, UserType.COMMON);

                User logist = new User(null, "Loja Exemplo", "loja@email.com", "33333333333",
                        encoder.encode("123456"), null, UserType.LOGIST);

                userRepository.saveAll(List.of(user1, user2, logist));


                Wallet wallet1 = new Wallet(null, new BigDecimal("1000.00"), user1);
                Wallet wallet2 = new Wallet(null, new BigDecimal("2000.00"), user2);
                Wallet wallet3 = new Wallet(null, new BigDecimal("5000.00"), logist);

                walletRepository.saveAll(List.of(wallet1, wallet2, wallet3));

                System.out.println("Usuários e carteiras populados com sucesso!");
            }
        };
    }
}
