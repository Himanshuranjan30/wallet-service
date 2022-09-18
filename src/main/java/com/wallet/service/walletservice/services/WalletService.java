package com.wallet.service.walletservice.services;

import com.wallet.service.walletservice.entities.UserWallet;
import com.wallet.service.walletservice.repository.WalletRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class WalletService {

    private final WalletRepo walletRepo;

    public UserWallet debitFromWallet(Long userId,Float amount){
        try {
            UserWallet userWallet = walletRepo.findByUserId(userId);
            Float existingBalance = userWallet.getBalance();
            Float newBalance = existingBalance - amount;
            userWallet.setBalance(newBalance);
            userWallet = walletRepo.save(userWallet);
            return userWallet;
        } catch (Exception e){
            log.error(e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    public UserWallet creditFromWallet(Long userId,Float amount){
        try {
            UserWallet userWallet = walletRepo.findByUserId(userId);
            Float existingBalance = userWallet.getBalance();
            Float newBalance = existingBalance + amount;
            userWallet.setBalance(newBalance);
            userWallet = walletRepo.save(userWallet);
            return userWallet;
        } catch (Exception e){
            log.error(e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    public UserWallet getWalletDetails(Long userId){
        return walletRepo.findByUserId(userId);
    }
}
