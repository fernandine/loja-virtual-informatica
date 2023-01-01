package com.jean.shop.ecommerce.controllers;

import com.jean.shop.ecommerce.dto.PaymentInfoDTO;
import com.jean.shop.ecommerce.dto.PurchaseDTO;
import com.jean.shop.ecommerce.dto.PurchaseResponseDTO;
import com.jean.shop.ecommerce.services.CheckoutService;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/checkout")
public class CheckoutResource {

    @Autowired
    private CheckoutService service;

    @PostMapping("/purchase")
    public ResponseEntity<PurchaseResponseDTO> placeOrder(@RequestBody PurchaseDTO purchase) {
        PurchaseResponseDTO purchaseResponse = service.placeOrder(purchase);
        return ResponseEntity.ok().body(purchaseResponse);
    }

    @PostMapping("/payment-intent")
    public ResponseEntity<String> createPaymentIntent(@RequestBody PaymentInfoDTO paymentInfo) throws StripeException {
        PaymentIntent paymentIntent = service.createPaymentIntent(paymentInfo);
        String paymentStr = paymentIntent.toJson();
        return new ResponseEntity<>(paymentStr, HttpStatus.OK);
    }
}
