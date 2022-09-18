package com.wallet.service.walletservice.repository;

import com.wallet.service.walletservice.entities.UserWallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepo extends JpaRepository<UserWallet,Long> {

    UserWallet findByUserId(Long userId);
}
