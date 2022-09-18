package com.wallet.service.walletservice.controllers;

import com.wallet.service.walletservice.models.UserLoginDTO;
import com.wallet.service.walletservice.models.UserOnboardDTO;
import com.wallet.service.walletservice.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@Slf4j
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    public ResponseEntity<?> registerNewUser(@RequestBody UserOnboardDTO userOnboardDTO){
          return new ResponseEntity<>(userService.registerUser(userOnboardDTO), HttpStatus.ACCEPTED);
    }

    public ResponseEntity<?> loginUser(@RequestBody UserLoginDTO userLoginDTO) {
        return new ResponseEntity<>(userService.loginUser(userLoginDTO),HttpStatus.ACCEPTED);
    }
}
