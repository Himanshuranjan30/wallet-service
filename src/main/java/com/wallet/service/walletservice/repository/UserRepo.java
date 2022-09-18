package com.wallet.service.walletservice.repository;

import com.wallet.service.walletservice.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {

    User findByUsername(String username);
}
