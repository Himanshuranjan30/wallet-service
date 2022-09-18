package com.wallet.service.walletservice.services;

import com.wallet.service.walletservice.entities.User;
import com.wallet.service.walletservice.entities.UserWallet;
import com.wallet.service.walletservice.models.UserLoginDTO;
import com.wallet.service.walletservice.models.UserOnboardDTO;
import com.wallet.service.walletservice.repository.UserRepo;
import com.wallet.service.walletservice.repository.WalletRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;

    private final WalletRepo walletRepo;

    public User registerUser(UserOnboardDTO userOnboardDTO){
        try {
            User newUser = User.builder()
                    .name(userOnboardDTO.getName())
                    .username(userOnboardDTO.getUsername())
                    .passwordHash(encryptPassword(userOnboardDTO.getPassword()))
                    .build();
            User createdUser = userRepo.save(newUser);
            UserWallet userWallet = UserWallet.builder()
                    .userId(createdUser.getId())
                    .balance(0F)
                    .build();
            walletRepo.save(userWallet);
            return createdUser;
        } catch (Exception e){
            log.error(e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    public Boolean loginUser(UserLoginDTO userLoginDTO){
        try {
            User user = userRepo.findByUsername(userLoginDTO.getUsername());
            if (!Objects.isNull(user)) {
                return checkPassword(userLoginDTO.getPassword(), user.getPasswordHash());
            }
            return false;
        } catch (Exception e){
            log.error(e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }


    private static String encryptPassword(String inputPassword) {
        StrongPasswordEncryptor encryptor = new StrongPasswordEncryptor();
        return encryptor.encryptPassword(inputPassword);
    }

    private static boolean checkPassword(String inputPassword, String encryptedStoredPassword) {
        StrongPasswordEncryptor encryptor = new StrongPasswordEncryptor();
        return encryptor.checkPassword(inputPassword, encryptedStoredPassword);
    }
}
