
package com.exchange.controller;


import com.exchange.dto.*;
import com.exchange.entity.CurrencyEnum;
import com.exchange.exceptions.UnsupportedCurrencyException;
import com.exchange.service.WalletService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @version 0.0.1
 */
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Slf4j
public class WalletController {

    private final WalletService walletService;

    @GetMapping("/user/{phone}/wallet")
    public UserWalletsDto getUserWallet(@RequestParam String phone) {
        return walletService.getUserWallets(phone);
    }

    @PostMapping("/create-wallet")
    public UserWalletsDto createWallet(@RequestBody WalletRequest wRequest){
        try {
            CurrencyEnum.valueOf(wRequest.currencyISO());
        } catch (IllegalArgumentException ex) {
            throw new UnsupportedCurrencyException();
        }

        return walletService.createWallet(wRequest);
    }

    @PostMapping("/put/verification")
    public Long putTransactionVerification(@RequestBody VerificationDto verificationDto){
        return walletService.putMoneyVerification(verificationDto);
    }

    @PostMapping("/put")
    public Long putMoneyToAccount(@RequestBody TransferDto transferDto) {
        return walletService.putMoney(transferDto);
    }

    @PostMapping("/get")
    public void getMoneyToAccount(@RequestBody TransferDto transferDto){
        walletService.getMonet(transferDto);

    }



}
