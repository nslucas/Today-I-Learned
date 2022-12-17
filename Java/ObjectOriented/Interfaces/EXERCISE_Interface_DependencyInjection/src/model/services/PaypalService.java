package model.services;

public class PaypalService implements OnlinePaymentService {
    @Override
    public double paymentFee(Double amount) {
        return amount * 0.02;
    }

    @Override
    public double interest(Double amount, Integer months) {
        return amount * 0.01 * months;
    }
}
