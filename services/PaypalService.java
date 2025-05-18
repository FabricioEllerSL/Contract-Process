package services;

import interfaces.PaymentService;

public class PaypalService implements PaymentService {

    @Override
    public Double paymentFee(Double amount) {
        return amount * 1.02;
    }

    @Override
    public double interest(Double amount, Integer month) {
        return amount + ((amount * 0.01) * month);
    }

}
