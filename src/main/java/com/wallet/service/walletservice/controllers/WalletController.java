package com.wallet.service.walletservice.controllers;

import com.wallet.service.walletservice.entities.UserWallet;
import com.wallet.service.walletservice.services.WalletService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@Slf4j
@RequestMapping("/wallet")
@RequiredArgsConstructor
public class WalletController {

    private final WalletService walletService;

    @PostMapping("/debit")
    public ResponseEntity<?> debitFromWallet(@RequestParam Long userId,@RequestParam Float amount){
        return new ResponseEntity(walletService.debitFromWallet(userId,amount), HttpStatus.ACCEPTED);
    }

    @PostMapping("/credit")
    public ResponseEntity<?> creditFromWallet(@RequestParam Long userId,@RequestParam Float amount){
        return new ResponseEntity(walletService.creditFromWallet(userId,amount), HttpStatus.ACCEPTED);
    }

    @GetMapping("/details")
    public ResponseEntity<?> getWalletDetails(@RequestParam Long userId){
        return new ResponseEntity(walletService.getWalletDetails(userId), HttpStatus.ACCEPTED);
    }
}
