package spring_boot.desafio.transactionApi.infra.mappers;

import spring_boot.desafio.transactionApi.domain.entities.User;
import spring_boot.desafio.transactionApi.infra.entities.UserEntity;

public class UserMapper {
    public static UserEntity toEntity(User user) {
        if (user == null) return null;

        UserEntity entity = new UserEntity();
        entity.setId(user.getId());
        entity.setFullName(user.getFullName());
        entity.setEmail(user.getEmail());
        entity.setCpfCnpj(user.getCpfCnpj());
        entity.setPassword(user.getPassword());
        entity.setUserType(user.getUserType());

        return entity;
    }

    public static User toDomain(UserEntity entity) {
        if (entity == null) return null;

        User user = new User();
        user.setId(entity.getId());
        user.setFullName(entity.getFullName());
        user.setEmail(entity.getEmail());
        user.setCpfCnpj(entity.getCpfCnpj());
        user.setPassword(entity.getPassword());
        user.setUserType(entity.getUserType());

        return user;
    }
}
