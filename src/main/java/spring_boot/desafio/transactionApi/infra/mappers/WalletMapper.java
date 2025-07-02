package spring_boot.desafio.transactionApi.infra.mappers;

import spring_boot.desafio.transactionApi.domain.entities.Wallet;
import spring_boot.desafio.transactionApi.infra.entities.WalletEntity;

public class WalletMapper {
    public static Wallet toDomain(WalletEntity entity) {
        if (entity == null) return null;

        Wallet wallet = new Wallet();
        wallet.setId(entity.getId());
        wallet.setBalance(entity.getBalance());
        wallet.setUser(UserMapper.toDomain(entity.getUser())); // converte UserEntity para User
        return wallet;
    }

    public static WalletEntity toEntity(Wallet wallet) {
        if (wallet == null) return null;

        WalletEntity entity = new WalletEntity();
        entity.setId(wallet.getId());
        entity.setBalance(wallet.getBalance());
        entity.setUser(UserMapper.toEntity(wallet.getUser())); // converte User para UserEntity
        return entity;
    }

}
