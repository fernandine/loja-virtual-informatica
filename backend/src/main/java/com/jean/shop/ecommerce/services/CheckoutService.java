package com.jean.shop.ecommerce.services;

import com.jean.shop.ecommerce.dto.PaymentInfoDTO;
import com.jean.shop.ecommerce.dto.PurchaseDTO;
import com.jean.shop.ecommerce.dto.PurchaseResponseDTO;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;

public interface CheckoutService {
    PurchaseResponseDTO placeOrder(PurchaseDTO purchase);
    PaymentIntent createPaymentIntent(PaymentInfoDTO paymentInfoDTO) throws StripeException;
}
