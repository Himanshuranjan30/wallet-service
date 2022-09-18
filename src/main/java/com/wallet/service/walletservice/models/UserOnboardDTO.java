package com.wallet.service.walletservice.models;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserOnboardDTO {

    @NotNull
    private String name;
    @NotNull
    private String username;
    @NotNull
    private String password;
}
