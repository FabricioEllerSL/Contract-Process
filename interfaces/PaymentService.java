package interfaces;

public interface PaymentService {
    public Double paymentFee(Double amount);
    public double interest(Double amount, Integer months);
}
