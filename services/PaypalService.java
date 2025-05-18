package services;

import interfaces.PaymentService;

public class PaypalService implements PaymentService {

    @Override
    public Double paymentFee(Double amount) {
        return amount * 0.02;
    }

    @Override
    public double interest(Double amount, Integer months) {
        return (amount * months) / 2;
    }

}
