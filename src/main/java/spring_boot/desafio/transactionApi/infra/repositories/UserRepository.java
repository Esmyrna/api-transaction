package spring_boot.desafio.transactionApi.infra.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring_boot.desafio.transactionApi.domain.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
}
