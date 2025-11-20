package fish.payara.service;

import jakarta.enterprise.context.Dependent;

import jakarta.persistence.EntityManager;
import jakarta.inject.Inject;
import fish.payara.domain.Payment;

@Dependent

public class PaymentService extends AbstractService<Payment, Integer> {

    public PaymentService() {
        super(Payment.class);
    }
    
}
